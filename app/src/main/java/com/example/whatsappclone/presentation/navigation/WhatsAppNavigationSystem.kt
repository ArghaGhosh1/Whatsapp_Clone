package com.example.whatsappclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.presentation.WelcomeScreen.welcomeScreen
import com.example.whatsappclone.presentation.homeScreen.homeScreen
import com.example.whatsappclone.presentation.spalashScreen.spalashScreen
import com.example.whatsappclone.presentation.updateScreen.updateScreen
import com.example.whatsappclone.presentation.userRagistrationScreen.userRagistrationScreen

@Composable
fun whatsAppNavigationSystem(){

    val navController = rememberNavController()

    NavHost(startDestination = Routes.spalashScreen, navController = navController){

        composable<Routes.spalashScreen>{
            spalashScreen(navController)
        }

        composable<Routes.welcomeScreen>{
            welcomeScreen(navController)
        }

        composable<Routes.userRegistrationScreen>{
            userRagistrationScreen(navController)
        }

        composable<Routes.homeScreen>{
            homeScreen(navController)
        }

        composable<Routes.updateScreen>{
            updateScreen(navController)
        }
    }
}