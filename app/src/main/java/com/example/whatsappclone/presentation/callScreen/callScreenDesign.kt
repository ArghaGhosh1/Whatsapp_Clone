package com.example.whatsappclone.presentation.callScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.homeScreen.bottomNavigation

@Composable
@Preview
fun callScreenDesign() {

    var favoritesDataList = listOf(
        favoritesList(R.drawable.carryminati, "Carry bhai"),
        favoritesList(R.drawable.carryminati, "Carry bhai"),
        favoritesList(R.drawable.carryminati, "Carry bhai"),
        favoritesList(R.drawable.carryminati, "Carry bhai"),
        favoritesList(R.drawable.carryminati, "Carry bhai"),
        favoritesList(R.drawable.carryminati, "Carry bhai")
    )

    Scaffold(
        bottomBar = {
            bottomNavigation()
        },


        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                color = ButtonDefaults.buttonColors(R.color.light_Green)
            ) {

                Icon(
                    painter = painterResource(R.drawable.outline_add_call_24),
                    contentDescription = null,
                    modifier = Modifier,
                )

            }
        },

        topBar = {
            topbar()
        }


    ) {

        Column(modifier = Modifier.padding(it)) {

            Text(
                "Favorites",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, top = 10.dp),
                fontSize = 20.sp
            )

            LazyRow() {
                items(favoritesDataList) {

                    favoriteSectionDesign(favoritesList = it)
                }
            }


        }
    }
}