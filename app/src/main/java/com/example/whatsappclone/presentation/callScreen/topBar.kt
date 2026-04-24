package com.example.whatsappclone.presentation.callScreen



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import org.w3c.dom.Text

@Composable
@Preview(showSystemUi = true)
fun topbar() {

    var isSearching by remember() {

        mutableStateOf(false)
    }

    var search by remember() {

        mutableStateOf("")
    }

    var expanded by remember{
        mutableStateOf(false)
    }



    Box(modifier = Modifier.fillMaxWidth()) {

        Column() {

            Row() {

                if (isSearching) {

                    TextField(
                        value = search,
                        onValueChange = {
                            search = it
                        },
                        colors = TextFieldDefaults.colors(

                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = { Text("Search") },
                        modifier = Modifier.padding(start = 12.dp, top = 15.dp),
                        singleLine = true
                    )
                } else {

                    Text(
                        "Calls",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top= 20.dp,start= 10.dp),
                    )

                }

                Spacer(modifier = Modifier.weight(1f))

                if (isSearching) {

                    IconButton(
                        onClick = {
                            isSearching = false
                        },
                        modifier = Modifier.padding(top = 16.dp, end = 12.dp),
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.cross),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp)
                        )
                    }

                }

                else{



                    IconButton(
                        onClick = {

                            isSearching = true
                        },
                        modifier = Modifier.padding(top = 16.dp, end = 12.dp),
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }

                    IconButton(
                        onClick = {

                            expanded = true
                        },
                        modifier = Modifier.padding(top = 16.dp, end = 12.dp),
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.more),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }

                    DropdownMenu(expanded = expanded, onDismissRequest = {expanded = false}){

                        listOf("Create channel", "Status privacy", "Starred", "Ad preferences", "Settings").forEach { item ->

                            DropdownMenuItem(text ={ Text(item)},onClick = {expanded = false})
                        }
                    }

                }
            }

            HorizontalDivider()
        }


    }

}