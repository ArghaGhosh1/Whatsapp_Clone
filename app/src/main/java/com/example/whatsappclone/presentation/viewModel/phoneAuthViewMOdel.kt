package com.example.whatsappclone.presentation.viewModel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.Model.phoneAuthData
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


@HiltViewModel
class phoneAuthViewMOdel @Inject constructor(

    private val firebaseAuth: FirebaseAuth,
    private val database: FirebaseDatabase
): ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(com.example.whatsappclone.presentation.viewModel.AuthState.Ideal)
    val authState = _authState.asStateFlow()

    private val userRef = database.reference.child("users")

    fun sendVarificationCode( phoneNumber:String, activity: Activity){

        _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.Loading

        val option = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)

                Log.d("phoneVarification","onCodeSent: $id")

                _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.CodeSent(verificationId = id)
            }



            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                TODO("Not yet implemented")
            }

            override fun onVerificationFailed(exception: FirebaseException) {
                Log.d("phoneAuth","varification failed: ${exception.message}")
                _authState.value = com.example.whatsappclone.presentation.viewModel.AuthState.error(exception.message ?: "varification failed" )
            }

        }



    }
}

sealed class AuthState(){

    object Ideal: AuthState()
    object Loading: AuthState()
    data class CodeSent(val verificationId: String): AuthState()
    data class succes(val user: phoneAuthData): AuthState()
    data class error(val message: String): AuthState()
}