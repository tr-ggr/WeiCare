package com.example.kotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Battery6Bar
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun Home(refreshState : MutableState<Int>) {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = CleanWhite, fontSize = 30.sp)) {
            append("Hello ")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = CleanWhite, fontSize = 30.sp)) {
            append("Adrian Sajulga")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = CleanWhite, fontSize = 30.sp)) {
            append(", relax and chill away.")
        }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .background(color = BackgroundColor)
                .fillMaxSize()
                .padding(25.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Text(
                        text = text,
                        color = CleanWhite,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Icon(imageVector = Icons.Default.Watch, contentDescription = "Home", tint = CleanWhite)
                Icon(imageVector = Icons.Default.Battery6Bar, contentDescription = "Home", tint = CleanWhite)
            }

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(15.dp),
                maxItemsInEachRow = 2
            ){
                TroponinCard(value = 0.01f)
                HomeCard(icon = Icons.Default.MonitorHeart, name = "Heart Rate", value = "86 BPM")
                HomeCard(icon = Icons.Default.Bloodtype, name = "Blood Pressure", value = "124/88 mmHg")
            }

            Spacer(modifier = Modifier.height(30.dp))


            StateTest(refreshState = refreshState)


        }
    }
}