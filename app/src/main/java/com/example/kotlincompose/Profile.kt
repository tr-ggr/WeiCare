package com.example.kotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.*


@Preview(showBackground = true)
@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize()
            .padding(25.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
                    .background(color = Color.Blue)

            ){

            }
            Text("Adrian Sajulga", color = CleanWhite, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }

        Divider( modifier = Modifier.width(100.dp), thickness = 1.dp, color = CleanWhite)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text("Age", color = CleanWhite, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    Text("22 years old", color = ChineseSilver)
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text("Average Heart Rate", color = CleanWhite, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    Text("62 - 73 bpm", color = ChineseSilver)
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text("Heart Status", color = CleanWhite, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    Text("Very Good", color = ChineseSilver)
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text("Average Troponin Levels", color = CleanWhite, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    Text("60 ng/mL", color = ChineseSilver)
                }
            }


        }

        Divider( modifier = Modifier.width(100.dp), thickness = 1.dp, color = CleanWhite)

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            ProfileButtons(icon = Icons.Outlined.CheckCircle, string = "Tips for Wellness")
            ProfileButtons(icon = Icons.Outlined.Call, string = "Contact Us")
            ProfileButtons(icon = Icons.Outlined.Info, string = "Data and Privacy")
            ProfileButtons(icon = Icons.Outlined.Settings, string = "Account Settings")
        }



    }

}