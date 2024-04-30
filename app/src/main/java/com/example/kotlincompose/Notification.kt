package com.example.kotlincompose

import android.content.res.Configuration
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.AppTheme
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun NotificationPreview(){
    AppTheme{
        Notification()
    }
}

@Composable
fun Notification() {
    var isAll by remember { mutableStateOf(true) }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(25.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)


//        verticalArrangement = Arrangement.Center
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {


                Row(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .width(150.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "More",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("All") },
                            onClick = { isAll = true }
                        )
                        DropdownMenuItem(
                            text = { Text("Unread") },
                            onClick = { isAll = false }
                        )
                    }

                    Text(
                        if (isAll) "All" else "Unread",
                        color = MaterialTheme.colorScheme.onBackground
                    )


                }


                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Read all")
                    
                }



        }

        Spacer(modifier = Modifier.height(10.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ){


            NotificationCard(isRead = false, type = NotificationType.DANGER)


        }


    }
}







