package com.example.kotlincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import com.example.kotlincompose.ui.theme.KotlinComposeTheme
import com.example.kotlincompose.ui.theme.WeiBlue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeTheme {

                    Main()


                }
            }
        }
    }



@Composable
fun Main() {
    val navigationController = rememberNavController()
    var selected by remember{
        mutableStateOf("WeiCare")
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.clip(CircleShape),
                onClick = {  },
                containerColor = DangerRed,
                contentColor = CleanWhite
            ) {
                Icon(Icons.Default.Phone, contentDescription = "Add")
            }
        },

                bottomBar = {
            BottomAppBar (
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 75.dp)
                    .background(color = WeiBlue),
                containerColor = WeiBlue,

            ) {
                MenuItem(icon = Icons.Default.Home,  name = "WeiCare", selected = selected) {
                    selected = "WeiCare"
                    navigationController.navigate(Screens.Home.screen){
                        popUpTo(0)
                    }
                }
                MenuItem(icon = Icons.Default.Person, name = "Contact", selected = selected) {
                    selected = "Contact"
                    navigationController.navigate(Screens.Contact.screen){
                        popUpTo(0)
                    }
                }
                FloatingActionButton(
                    modifier = Modifier
                        .size(80.dp),
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 5.dp),

                    ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
                MenuItem(icon = Icons.Default.Notifications, name = "Notification", selected = selected) {
                    selected = "Notification"
                    navigationController.navigate(Screens.Notification.screen){
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
    ) {paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
        ){
            composable(route = Screens.Home.screen){ Home() }
            composable(route = Screens.Profile.screen){ Profile() }
            composable(route = Screens.Notification.screen){ Notification() }
            composable(route = Screens.Contact.screen){ Contact() }
        }

    }

}

@Composable
fun MenuItem(icon : ImageVector, name : String, selected : String,  onClick: () -> Unit) {

    IconButton(
        onClick = onClick,
        modifier = Modifier.then(Modifier.size(75.dp))
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                modifier = Modifier.size(35.dp),
                contentDescription = null,
                tint = if (selected == name) BackgroundColor else Color.White
            )
            Text(text = name, fontSize = 10.sp, color = if (selected == name) BackgroundColor else Color.White)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun NavbarPreview() {
    KotlinComposeTheme {
        Main()
    }
}



