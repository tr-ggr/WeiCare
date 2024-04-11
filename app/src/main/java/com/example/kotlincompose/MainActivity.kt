package com.example.kotlincompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
 import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlincompose.ui.theme.KotlinComposeTheme
import com.example.kotlincompose.ui.theme.*


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
        bottomBar = {
            BottomAppBar (
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 75.dp)
                    .background(color = PrimaryColor),
                containerColor = PrimaryColor
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
                tint = if (selected == name) Color.Black else Color.White
            )
            Text(text = name, fontSize = 10.sp, color = if (selected == name) Color.Black else Color.White)

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



