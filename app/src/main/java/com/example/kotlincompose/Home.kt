package com.example.kotlincompose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Battery6Bar
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlincompose.ui.theme.AppTheme
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite



//@Composable
//fun previewHome() {
//    AppTheme{
//        Home()
//    }
//
//}
@OptIn(ExperimentalLayoutApi::class)
@Composable
//refreshState : MutableState<Int>, navigationController : NavController
fun Home(navigationController : NavController) {

   Column (
       modifier = Modifier
           .fillMaxSize()
           .background(MaterialTheme.colorScheme.background)
           .padding(15.dp),
       verticalArrangement = Arrangement.spacedBy(40.dp)
   ){
       Row(
           modifier = Modifier
               .fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically
       ) {
           Row(
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ){
               Box(
                   modifier = Modifier

                       .size(50.dp)
                       .clip(CircleShape)
                       .background(MaterialTheme.colorScheme.onSurface),
               )

               Spacer(modifier = Modifier.width(10.dp))

               Text(
                   buildAnnotatedString {
                       withStyle(style = SpanStyle(fontSize = 10.sp)) {
                           append("Hello!")
                       }
                       append("\n") // New line
                       withStyle(style = SpanStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)) {
                           append("Adrian Sajulga")
                       }
                   },
                   color = MaterialTheme.colorScheme.onBackground,
                   lineHeight = 15.sp
               )
           }

           IconButton(onClick = {
               navigationController.navigate(Screens.Notification.screen){
               popUpTo(0)
           } }) {
               Icon(
                   imageVector = Icons.Outlined.Notifications,
                   contentDescription = "Home",
                   tint = MaterialTheme.colorScheme.onBackground
               )
           }



       }

       Row(
              modifier = Modifier.fillMaxWidth()
                  .height(IntrinsicSize.Min),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
         ) {
           TroponinCard(value = 20f)
           Column (
               modifier = Modifier.height(IntrinsicSize.Min),
               verticalArrangement = Arrangement.spacedBy(10.dp)
           ){
               HomeCard(icon = Icons.Filled.BubbleChart, name = "Troponin-I", value = "20.0 ng/mL")
               HomeCard(icon = Icons.Filled.MonitorHeart, name = "Heart Rate", value = "80 bpm")
               HomeCard(icon = Icons.Filled.Bloodtype, name = "Blood Pressure", value = "120/80 mmHg")
           }


         }

       StateTest()
   }
}
