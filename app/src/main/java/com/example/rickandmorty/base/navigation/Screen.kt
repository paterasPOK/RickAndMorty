package com.example.rickandmorty.base.navigation

sealed class Screen(
    val route: String
) {
    data object CharactersScreen : Screen(route = "characters_screen")
    data object CharactersInfoScreen : Screen(route = "characters_info_screen")
}