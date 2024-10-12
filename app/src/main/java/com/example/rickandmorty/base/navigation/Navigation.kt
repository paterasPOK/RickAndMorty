package com.example.rickandmorty.base.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.base.theme.RickPrimary
import com.example.rickandmorty.feature.character.CharactersScreen
import com.example.rickandmorty.utils.rickAndMortyNavigateSingleTop

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CharactersScreen.route
    ) {
        composable(route = Screen.CharactersScreen.route) {
            CharactersScreen(
                navController,
                modifier = Modifier
                    .background(RickPrimary),
                onCharacterClicked = { characterId ->
                    navController.rickAndMortyNavigateSingleTop("${Screen.CharactersInfoScreen.route}/$characterId")
                }
            )
        }
    }
}