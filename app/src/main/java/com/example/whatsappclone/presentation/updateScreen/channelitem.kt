package com.example.whatsappclone.presentation.updateScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

@Composable
fun channelitem(channelDataList: channelDataList) {

    var isFolowing by remember() {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Box() {
            Image(
                painter = painterResource(channelDataList.image),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
            )


        }

        Column(modifier = Modifier.padding(10.dp)) {

            Text(
                channelDataList.channel,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 10.dp),
                fontSize = 18.sp
            )

            Text(
                channelDataList.channelDes, color = Color.LightGray,
                modifier = Modifier
                    .padding(start = 10.dp),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { isFolowing = !isFolowing },
            colors = ButtonDefaults.buttonColors(

                containerColor = if (isFolowing) {
                    Color.Gray
                } else {
                    colorResource(R.color.light_Green)
                }
            ),
        ) {

            Text(
                if (isFolowing) {
                    "Following"
                } else {
                    "Follow"
                },
                color = if (isFolowing){
                    Color.Black
                }
                else{
                    Color.White
                }
            )

        }

    }
}