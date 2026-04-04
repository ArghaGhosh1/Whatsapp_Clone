package com.example.whatsappclone.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

@Composable
fun chatDesign( chatListModel: chatListModel){

    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){

        Image(
            painter = painterResource(chatListModel.image),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(){

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){

                Text(chatListModel.name, fontSize = 18.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 10.dp, bottom = 5.dp))
                Text(chatListModel.time,modifier = Modifier.padding(bottom = 5.dp))

            }

            Text(chatListModel.message, color = Color.LightGray,modifier = Modifier.padding(start = 10.dp))
        }
    }



}