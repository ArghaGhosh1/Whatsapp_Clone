package com.example.whatsappclone.presentation.viewModel

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.Model.phoneAuthData
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.ByteArrayOutputStream
import java.util.concurrent.TimeUnit


@HiltViewModel
class phoneAuthViewMOdel @Inject constructor(

    private val firebaseAuth: FirebaseAuth,
    private val database: FirebaseDatabase
) : ViewModel() {

    private val _authState =
        MutableStateFlow<AuthState>(com.example.whatsappclone.presentation.viewModel.AuthState.Ideal)
    val authState = _authState.asStateFlow()

    private val userRef = database.reference.child("users")

    fun sendVarificationCode(phoneNumber: String, activity: Activity) {

        _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.Loading

        val option = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)

                Log.d("phoneVarification", "onCodeSent: $id")

                _authState.value =
                    com.example.whatsappclone.presentation.viewModel.AuthState.codeSent(
                        verificationId = id
                    )
            }


            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                signInWithCredentials(credential, context = activity)

            }

            override fun onVerificationFailed(exception: FirebaseException) {
                Log.d("phoneAuth", "varification failed: ${exception.message}")
                _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.error(
                    exception.message ?: "varification failed"
                )
            }

        }

        val phoneAuthOptions = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(option)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions)

    }

    private fun signInWithCredentials(credential: PhoneAuthCredential, context: Context) {

        _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.Loading

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                val phoneAuthUser = phoneAuthData(

                    userId = user?.uid ?: "",
                    phoneNumber = user?.phoneNumber ?: ""

                )

                markUserAsSignedIn(context)
                _authState.value =
                    com.example.whatsappclone.presentation.viewModel.AuthState.succes(phoneAuthUser)

                fetchUserProfile(user?.uid ?: "")
            } else {
                _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.error(
                    task.exception?.message ?: "signIn failed"
                )
            }

        }


    }

    private fun markUserAsSignedIn(context: Context) {

        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("isSignedIn", true).apply()
    }

    private fun fetchUserProfile(userId: String) {

        val userRef = userRef.child(userId)
        userRef.get().addOnSuccessListener { snapshot ->

            if (snapshot != null) {
                val userProfile = snapshot.getValue(phoneAuthData::class.java)
                if (userProfile != null) {
                    _authState.value =
                        com.example.whatsappclone.presentation.viewModel.AuthState.succes(
                            userProfile
                        )
                }
            }
        }
            .addOnFailureListener {
                _authState.value =
                    com.example.whatsappclone.presentation.viewModel.AuthState.error("Failed to fetch user profile")
            }

    }

    fun verifyCode(otp: String, context: Context) {

        val currentAuthState = _authState.value

        if (currentAuthState !is AuthState.codeSent || currentAuthState.verificationId.isEmpty()) {

            Log.e("PhoneAuth", "Attempting to verify OTP without a valid verfication code")

            _authState.value =
                com.example.whatsappclone.presentation.viewModel.AuthState.error("varification not started or invalid Id")

            return
        }

        val credential = PhoneAuthProvider.getCredential(currentAuthState.verificationId,otp)
        signInWithCredentials(credential,context)
    }

    fun saveUserProfile(userId : String,name: String, status: String,profileImage: Bitmap?){

        val database = FirebaseDatabase.getInstance().reference

        val encodedImage = profileImage?.let { convertBitmapToBase64(it) }

        val userProfile = phoneAuthData(
            userId = userId,
            name = name,
            status = status,
            profileImage = encodedImage
        )

        database.child("users").child(userId).setValue(userProfile)
    }

    fun convertBitmapToBase64(bitmap: Bitmap): String{

        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return android.util.Base64.encodeToString(byteArray, android.util.Base64.DEFAULT)

    }

    fun resetAuthState(){
        _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.Ideal
    }

    fun signOut(activity: Activity){

        firebaseAuth.signOut()
        val sharedPreference = activity.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        sharedPreference.edit().putBoolean("isSignedIn",false).apply()
    }


}

sealed class AuthState() {

    object Ideal : AuthState()
    object Loading : AuthState()
    data class codeSent(val verificationId: String) : AuthState()
    data class succes(val user: phoneAuthData) : AuthState()
    data class error(val message: String) : AuthState()
}