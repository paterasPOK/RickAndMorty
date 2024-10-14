package com.example.rickandmorty.base.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.rickandmorty.base.theme.RickPrimary
import com.example.rickandmorty.feature.character.CharactersScreen
import com.example.rickandmorty.feature.character.character_info_screen.CharacterInfoScreen
import com.example.rickandmorty.feature.character.viewmodels.CharactersGraphViewModel
import com.example.rickandmorty.utils.rickAndMortyNavigateSingleTop
import com.example.rickandmorty.utils.routeViewModelWithBackStack


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "characters_route"
    ) {
        charactersGraph(navController)
    }
}

fun NavGraphBuilder.charactersGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.CharactersScreen.route,
        route = "characters_route"
    ) {
        composable(route = Screen.CharactersScreen.route) { backstackEntry ->
            val viewModel: CharactersGraphViewModel = navController.routeViewModelWithBackStack(
                entry = backstackEntry,
                graphRoute = "characters_route"
            )
            CharactersScreen(
                navController,
                modifier = Modifier
                    .background(RickPrimary),
                onCharacterClicked = { characterId ->
                    viewModel.getCharacterById(characterId)
                    navController.rickAndMortyNavigateSingleTop(Screen.CharactersInfoScreen.route)
                }
            )
        }

        composable(route = Screen.CharactersInfoScreen.route) { backStackEntry ->
            val viewModel: CharactersGraphViewModel = navController.routeViewModelWithBackStack(
                entry = backStackEntry,
                graphRoute = "characters_route"
            )
            val character by viewModel.character.collectAsState()
            character?.let {
                CharacterInfoScreen(
                    character = it,
                    modifier = Modifier.background(RickPrimary)
                )
            }
        }
    }
}


