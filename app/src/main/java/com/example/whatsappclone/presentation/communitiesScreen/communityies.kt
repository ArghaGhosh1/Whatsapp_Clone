package com.example.whatsappclone.presentation.communitiesScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun communitiesListDesign(communityList: communityList) {

    Row(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    )
    {

        Image(
            painter = painterResource(communityList.image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,


            )

        Column() {

            Text(
                communityList.name,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )

            Text(
                "${communityList.members} members",
                color = Color.LightGray,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }


    }

}

