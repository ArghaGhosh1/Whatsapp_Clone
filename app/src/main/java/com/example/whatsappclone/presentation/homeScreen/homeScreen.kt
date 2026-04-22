package com.example.whatsappclone.presentation.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R

@Composable
fun homeScreen(navController: NavHostController) {

    val chatData = listOf(
        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),

        chatListModel(
            R.drawable.salman_khan,
            "Salman Khan",
            "10:00 AM",
            "hello"
        ),
    )

    Scaffold(

        floatingActionButton = {

            FloatingActionButton(
                onClick = {}, containerColor = colorResource(R.color.light_Green)
            ) {

                Icon(
                    painter = painterResource(R.drawable.chat_icon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)

                )
            }
        },

        bottomBar = {

            bottomNavigation()
        }


    ) {

        Column(modifier = Modifier.padding(it)) {

            Spacer(
                modifier = Modifier.height(16.dp)
            )


            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "WhatsApp",
                    fontSize = 28.sp,
                    color = colorResource(R.color.light_Green),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                )

                Row(modifier = Modifier.align(alignment = Alignment.CenterEnd)) {


                    IconButton(onClick = {}) {

                        Icon(
                            painter = painterResource(R.drawable.camera),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                        )
                    }

                    IconButton(onClick = {}) {

                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                        )
                    }

                    IconButton(onClick = {}) {

                        Icon(
                            painter = painterResource(R.drawable.more),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                        )
                    }
                }

            }
            HorizontalDivider()

            LazyColumn {

                items(chatData) {

                    chatDesign(chatListModel = it)
                }
            }

        }

    }
}