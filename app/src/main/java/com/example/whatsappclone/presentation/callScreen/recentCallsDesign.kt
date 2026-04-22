package com.example.whatsappclone.presentation.callScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

@Composable
fun recentCallDesign(recentCallsList: recentCallsList) {

    val isMissedCall by remember() {
        mutableStateOf(true)
    }

    Row(
        modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(recentCallsList.image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop

        )

        Column(modifier = Modifier.padding(start = 10.dp)) {

            Text(
                recentCallsList.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                )

            Row(verticalAlignment = Alignment.CenterVertically) {


                Icon(
                    painter = painterResource(R.drawable.missed_call),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = if (recentCallsList.isMissedCall) {
                        Color.Red
                    } else {
                        Color.Green
                    }

                )


                Text(recentCallsList.time, modifier = Modifier, color = Color.Gray, fontSize = 16.sp)


            }

        }
    }

}