package com.example.kotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.*
import com.example.kotlincompose.ui.theme.KotlinComposeTheme

@Preview(showBackground = true)
@Composable
fun Preview(){
    GoodNotificationCard(true)
}

@Composable
fun GoodNotificationCard(isRead : Boolean){
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp)).background(color = if(isRead) Color.Black else SecondaryColor).padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = GoodGreen),
            contentAlignment = Alignment.Center

            

        ){
            Icon(imageVector = Icons.Default.FavoriteBorder , contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(

        ){
            Text("8:50 am - Today", color = ChineseSilver, fontSize = 10.sp)
            Text("You're in Good Shape!", color = Color.White, fontWeight = FontWeight.Bold)
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.  of Lorem Ipsum.", color = Color.White, fontSize = 10.sp)
        }



    }

}


@Composable
fun RiskyNotificationCard(isRead : Boolean){
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp)).background(color = if(isRead) Color.Black else SecondaryColor).padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = RiskyOrange),
            contentAlignment = Alignment.Center



        ){
            Icon(imageVector = Icons.Outlined.Warning, contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(

        ){
            Text("8:50 am - Today", color = ChineseSilver, fontSize = 10.sp)
            Text("You’re at Risk!", color = Color.White, fontWeight = FontWeight.Bold)
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.  of Lorem Ipsum.", color = Color.White, fontSize = 10.sp)
        }


    }

}



@Composable
fun DangerNotificationCard(isRead : Boolean){
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp)).background(color = if(isRead) Color.Black else SecondaryColor).padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = DangerRed),
            contentAlignment = Alignment.Center



        ){
            Icon(imageVector = Icons.Outlined.Warning, contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(

        ){
            Text("8:50 am - Today", color = ChineseSilver, fontSize = 10.sp)
            Text("You were in danger!", color = Color.White, fontWeight = FontWeight.Bold)
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.  of Lorem Ipsum.", color = Color.White, fontSize = 10.sp)
        }


    }

}
