package com.example.whatsappclone

sealed class Screen(val route: String) {

    object splashScreen: Screen("Splash_Screen")
    object welcomeScreen: Screen("Welcome_Screen")
    object userRagistrationScreen: Screen("UserRagistration_Screen")
    object homeScreen: Screen("Home_Screen")
    object updateScreen: Screen("Update_Screen")
    object communitiesScreen: Screen("Communities_Screen")
    object callScreen: Screen("Call_Screen")

}