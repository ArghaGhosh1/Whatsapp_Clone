package com.example.whatsappclone

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsappclone.presentation.WelcomeScreen.welcomeScreen
import com.example.whatsappclone.presentation.homeScreen.homeScreen
import com.example.whatsappclone.presentation.spalashScreen.spalashScreen
import com.example.whatsappclone.presentation.userRagistrationScreen.userRagistrationScreen

@Composable
fun setupNavGraph(navController: NavHostController){

    NavHost(startDestination = Screen.splashScreen.route,navController = navController){

        composable(Screen.splashScreen.route){

            spalashScreen(navController = navController)
        }


        composable(Screen.welcomeScreen.route){

            welcomeScreen(navController = navController)
        }


        composable(Screen.userRagistrationScreen.route){

            userRagistrationScreen(navController = navController)
        }


        composable(Screen.homeScreen.route){

            homeScreen(navController = navController)
        }
    }


}