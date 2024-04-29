package com.example.kotlincompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.CleanWhite
import com.example.kotlincompose.ui.theme.DangerRed
import com.example.kotlincompose.ui.theme.AppTheme
import com.example.kotlincompose.ui.theme.GoodGreen
import com.example.kotlincompose.ui.theme.WeiBlue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                    Main()
                }
            }
        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    val refreshState = remember { mutableStateOf(0) }
    val navigationController = rememberNavController()
    var selected by remember{
        mutableStateOf("WeiCare")
    }

    Scaffold (
        floatingActionButton = {
            if(selected == "WeiCare" || selected == "Profile") null else ExtendedFloatingActionButton(
//                modifier = Modifier.clip(CircleShape),
                onClick = {  },
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary,
                elevation = FloatingActionButtonDefaults.elevation()

            ){
                Icon(Icons.Default.Add, contentDescription = "Add")
                Text(if(selected == "Device") "Add Device" else "Add Contact")
            }
        },
        topBar = {
            if(selected == "WeiCare") null else TopAppBar(title = { Text(selected) },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                )
            )
        },

                bottomBar = {
            BottomAppBar (
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 75.dp)
                    .background(color = MaterialTheme.colorScheme.tertiary,),
                containerColor = MaterialTheme.colorScheme.primary,


            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    MenuItem(icon = Icons.Default.Home,  name = "WeiCare", selected = selected) {
                        selected = "WeiCare"
                        navigationController.navigate(Screens.Home.screen){
                            popUpTo(0)
                        }
                    }
                    MenuItem(icon = Icons.Default.Watch, name = "Device", selected = selected) {
                        selected = "Device"
                        navigationController.navigate(Screens.Device.screen){
                            popUpTo(0)
                        }
                    }
                    MenuItem(icon = Icons.Default.Person, name = "Contact", selected = selected) {
                        selected = "Contact"
                        navigationController.navigate(Screens.Contact.screen){
                            popUpTo(0)
                        }
                    }

                    MenuItem(icon = Icons.Default.AccountCircle, name = "Profile", selected = selected) {
                        selected = "Profile"
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    }
                }

            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
        ){
            composable(route = Screens.Home.screen){ Home(navigationController) }
            composable(route = Screens.Profile.screen){ Profile() }
            composable(route = Screens.Notification.screen){ Notification() }
            composable(route = Screens.Contact.screen){ Contact() }
            composable(route = Screens.Device.screen){ Device() }
        }

    }

}

@Composable
fun MenuItem(icon : ImageVector, name : String, selected : String,  onClick: () -> Unit) {

    IconButton(
        onClick = onClick,
        modifier = Modifier.size(75.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                modifier = Modifier.size(35.dp),
                contentDescription = null,
                tint = if (selected == name) WeiBlue else MaterialTheme.colorScheme.onPrimary
            )
            Text(text = name, fontSize = 10.sp, color = if (selected == name) WeiBlue else MaterialTheme.colorScheme.onPrimary)

        }

    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun NavbarPreview() {
    AppTheme {
        Main()
    }
}



