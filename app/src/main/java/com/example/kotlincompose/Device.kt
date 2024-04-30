package com.example.kotlincompose

import android.content.res.Configuration
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite
import com.example.kotlincompose.ui.theme.GoodGreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.example.kotlincompose.ui.theme.AppTheme

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)

@Composable
fun PreviewDevice() {
    AppTheme{
        Device()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun Device() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ){
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp)
                    .background(color = MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center


            ){
                Icon(imageVector = Icons.Default.Watch, contentDescription = null, tint = Color.White, modifier = Modifier.size(100.dp))

            }
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.Bold, fontSize = 50.sp)) {
                        append("Active")
                    }
                    append("\n") // New line
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 25.sp)) {
                        append("100%")
                    }
                },
                textAlign = TextAlign.Center,
                lineHeight = 30.sp

            )

        }


        Column (
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text ="Device list", color = MaterialTheme.colorScheme.onBackground,  fontSize = 15.sp, fontWeight = FontWeight.Medium)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ){
                DeviceCard(name = "John Smith", "100")
            }

            Spacer(modifier = Modifier.height(30.dp))
        }






    }
}