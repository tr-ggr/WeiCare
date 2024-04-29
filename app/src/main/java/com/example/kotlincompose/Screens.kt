package com.example.kotlincompose

sealed class Screens (val screen : String){
    data object Home: Screens("home")
    data object Contact: Screens("contact")
    data object Notification: Screens("notification")
    data object Profile: Screens("profile")
    data object Device: Screens("device")
}