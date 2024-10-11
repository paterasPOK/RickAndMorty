package com.example.rickandmorty.feature.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.feature.character.composables.CharacterCard
import com.example.rickandmorty.feature.character.viewmodels.CharactersViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CharactersScreen(
    modifier: Modifier,
    viewModel: CharactersViewModel = getViewModel<CharactersViewModel>()
) {
    val lazyListState = rememberLazyListState()
    val characterListState by viewModel.charactersListResultState.collectAsState(initial = null)

    characterListState?.let { characters ->
        LazyColumn(
            state = lazyListState,
            modifier = modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            items(characters.chunked(2)) { rowCharactersItems ->
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowCharactersItems.forEach { rowCharacter ->
                        CharacterCard(result = rowCharacter, modifier = Modifier.weight(1f))
                        if (rowCharactersItems.size != 2) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}