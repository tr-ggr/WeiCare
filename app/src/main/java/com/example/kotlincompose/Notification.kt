package com.example.kotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite

@Preview(showBackground = true)
@Composable
fun Notification() {

    Column(
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize()
            .padding(25.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)


//        verticalArrangement = Arrangement.Center
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Notifications", color = CleanWhite, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(modifier = Modifier.width(100.dp), thickness = 2.dp, color = CleanWhite)
        Spacer(modifier = Modifier.height(30.dp))

        Row{
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(100.dp)
                    .height(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ChineseSilver )
            ) {
                Text("All", fontSize = 10.sp,fontWeight = FontWeight.Bold, color = BackgroundColor)
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(100.dp)
                    .height(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BackgroundColor)
            ) {
                Text("Unread", fontSize = 10.sp)
                Spacer(modifier = Modifier.width(2.dp))
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(5.dp)
                    .background(color = Color.Blue)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,

        ){
            Text(text ="New", color = CleanWhite, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(90.dp)
                    .height(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ChineseSilver )

            ) {
                Text("Read All", fontSize = 10.sp, color = BackgroundColor)
            }
        }


        GoodNotificationCard(isRead = true)
        GoodNotificationCard(isRead = true)
        RiskyNotificationCard(isRead = false)
        DangerNotificationCard(isRead = true)
        RiskyNotificationCard(isRead = false)
        DangerNotificationCard(isRead = true)
        GoodNotificationCard(isRead = true)
        RiskyNotificationCard(isRead = false)
        DangerNotificationCard(isRead = true)
        GoodNotificationCard(isRead = true)
        GoodNotificationCard(isRead = true)
        RiskyNotificationCard(isRead = false)
        DangerNotificationCard(isRead = true)
        RiskyNotificationCard(isRead = false)
        DangerNotificationCard(isRead = true)


    }
}
