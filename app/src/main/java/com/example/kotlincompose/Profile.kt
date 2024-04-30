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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
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
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
                    .background(color = MaterialTheme.colorScheme.onBackground)

            ){

            }
            Text("Adrian Sajulga", color = MaterialTheme.colorScheme.onBackground, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }

        Column (
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text ="Personal Information", color = MaterialTheme.colorScheme.onBackground, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                maxItemsInEachRow = 2
            ){
                HomeCard(icon = Icons.Outlined.Info, name = "About", value = "Laine Segundo")
                HomeCard(icon = Icons.Outlined.Info, name = "About", value = "Laine Segundo")
                HomeCard(icon = Icons.Outlined.Info, name = "About", value = "Laine Segundo")
                HomeCard(icon = Icons.Outlined.Info, name = "About", value = "Laine Segundo")
            }

        }

        Column (
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text ="Utilities", color = MaterialTheme.colorScheme.onBackground, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(3.dp),
            ){
                ProfileButtons(icon = Icons.Outlined.Call, string = "Call")
                ProfileButtons(icon = Icons.Outlined.Call, string = "Call")
                ProfileButtons(icon = Icons.Outlined.Call, string = "Call")
                ProfileButtons(icon = Icons.Outlined.Call, string = "Call")
                ProfileButtons(icon = Icons.Outlined.Call, string = "Call")
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }

}