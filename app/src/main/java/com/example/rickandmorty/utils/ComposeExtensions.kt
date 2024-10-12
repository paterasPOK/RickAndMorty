package com.example.rickandmorty.utils

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

fun NavController.rickAndMortyNavigatePopUp(
    navBuilder: NavOptionsBuilder.() -> Unit = {}
) {
    if (currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
        popBackStack()
    }
}

fun NavController.rickAndMortyNavigateSingleTop(
    route: String,
    navBuilder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route) {
        this.apply(navBuilder)
        launchSingleTop = true
    }

}