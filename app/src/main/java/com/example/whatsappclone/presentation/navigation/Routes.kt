package com.example.whatsappclone.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object spalashScreen : Routes()

    @Serializable
    data object welcomeScreen : Routes()

    @Serializable
    data object userRegistrationScreen : Routes()

    @Serializable
    data object homeScreen : Routes()

    @Serializable
    data object updateScreen : Routes()


}