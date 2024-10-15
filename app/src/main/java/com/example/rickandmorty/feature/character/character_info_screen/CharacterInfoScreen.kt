package com.example.rickandmorty.feature.character.character_info_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.characters.Result
import com.example.rickandmorty.base.composables.CharacterDataInfoColumn
import com.example.rickandmorty.base.composables.RickAndMortyImage
import com.example.rickandmorty.base.theme.RickAction
import com.example.rickandmorty.feature.character.composables.CharacterStatusComponent

@Composable
fun CharacterInfoScreen(
    character: Result,
    modifier: Modifier
) {
    val context = LocalContext.current
    val state = rememberLazyListState()
    val characterInfoList = remember {
        listOf(
            "Last known Location" to character.location.name,
            "Species" to character.species,
            "Gender" to character.gender,
            "Origin" to character.origin.name,
            "Episodes Count" to character.episode.size.toString()
        )
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = state
    ) {
        item {
            CharacterStatusComponent(status = character.status)
        }
        item {
            Text(
                text = character.name,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = RickAction
            )
        }
        item {
            RickAndMortyImage(imageUrl = character.image, context = context, modifier = modifier)
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(
            items = characterInfoList,
            key = { info -> info.first }
        ) { info ->
            CharacterDataInfoColumn(title = info.first, description = info.second)
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
