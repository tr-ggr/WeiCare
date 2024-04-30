package com.example.kotlincompose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.GeneratingTokens
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.VerifiedUser
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.*

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun ProfilePreview(){
    AppTheme{
        Profile()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(75.dp)
                    .background(color = MaterialTheme.colorScheme.onBackground)

            ){

            }

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 30.sp, fontWeight = FontWeight.Bold)) {
                        append("Adrian Sajulga")
                    }
                    append("\n") // New line
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 20.sp)) {
                        append("Huawei Account")
                    }
                }
            )



        }

        Column (
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ){
            Text(text ="Personal Information", color = MaterialTheme.colorScheme.onBackground, fontSize = 15.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                HomeCard(icon = Icons.Outlined.Info, name = "Age", value = "22 years old", roundClip = RoundedCornerShape(15.dp, 5.dp, 5.dp, 5.dp))
                HomeCard(icon = Icons.Outlined.MonitorHeart, name = "Heart Status", value = "Very Good",  roundClip = RoundedCornerShape(5.dp, 15.dp, 5.dp, 5.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ){
                HomeCard(icon = Icons.Outlined.MonitorWeight, name = "Weight", value = "70kg",  roundClip = RoundedCornerShape(5.dp, 5.dp, 5.dp, 15.dp))
                HomeCard(icon = Icons.Outlined.Height, name = "Height", value = "180 cm",  roundClip = RoundedCornerShape(5.dp, 5.dp, 15.dp, 5.dp))
            }

        }

        Column (
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text ="Utilities", color = MaterialTheme.colorScheme.onBackground, fontSize = 15.sp, fontWeight = FontWeight.Medium)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(3.dp),
            ){
                ProfileButtons(icon = Icons.Outlined.Call, string = "Call")
                ProfileButtons(icon = Icons.Outlined.Info, string = "About")
                ProfileButtons(icon = Icons.Outlined.Settings, string = "Settings")
                ProfileButtons(icon = Icons.Outlined.VerifiedUser, string = "Verify")
                ProfileButtons(icon = Icons.Outlined.People, string = "Support")
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }



}

