package com.example.rickandmorty.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import org.koin.androidx.compose.getViewModel

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

@Composable
inline fun <reified VM : ViewModel> NavController.routeViewModelWithBackStack(
    entry: NavBackStackEntry,
    graphRoute: String? = null,
): VM {
    val inRoute = graphRoute ?: entry.destination.route
    val backStackEntry =
        remember(entry) {
            if (inRoute != null)
                getBackStackEntry(inRoute)
            else
                currentBackStackEntry
        }
    return getViewModel(
        owner = backStackEntry ?: entry,
    )
}