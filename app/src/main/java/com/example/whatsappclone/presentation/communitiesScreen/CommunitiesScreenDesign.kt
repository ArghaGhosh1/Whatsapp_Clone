package com.example.whatsappclone.presentation.communitiesScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.homeScreen.bottomNavigation

@Composable
@Preview(showSystemUi = true)
fun communitiesScreen() {

    var dataList = listOf(
        communityList(R.drawable.img, "Tech enthusias", 256),
        communityList(R.drawable.img, "Photography enthusias", 50),
        communityList(R.drawable.img, "Book enthusias", 355)
    )

    Scaffold(

        topBar = {
            topbar()
        },

        bottomBar = {

            bottomNavigation()
        }


    ) {

        Column(modifier = Modifier.padding(it)) {

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.light_Green)
                )
            ) {

                Text("Start a new community")

            }

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                "Your Communities",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(all = 10.dp),
                fontSize = 20.sp
            )


            LazyColumn(){
                items(dataList){
                    
                    communitiesListDesign(communityList = it)
                }
            }

        }

    }
}