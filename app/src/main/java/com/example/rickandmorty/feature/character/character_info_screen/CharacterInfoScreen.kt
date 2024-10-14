package com.example.rickandmorty.feature.character.character_info_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.domain.models.characters.Result
import com.example.rickandmorty.base.composables.CharacterDataInfoColumn
import com.example.rickandmorty.base.composables.RickAndMortyImage

@Composable
fun CharacterInfoScreen(
    character: Result,
    modifier: Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = character.status
        )
        Text(
            text = character.name
        )
        Spacer(modifier = Modifier.height(8.dp))

        RickAndMortyImage(imageUrl = character.image, context = context, modifier = modifier)
        Spacer(modifier = Modifier.height(8.dp))
        CharacterDataInfoColumn(
            title = "Last known Location",
            description = character.location.name
        )
        Spacer(modifier = Modifier.height(8.dp))
        CharacterDataInfoColumn(title = "Species", description = character.species)
        Spacer(modifier = Modifier.height(8.dp))
        CharacterDataInfoColumn(title = "Gender", description = character.gender)
        Spacer(modifier = Modifier.height(8.dp))
        CharacterDataInfoColumn(title = "Origin", description = character.origin.name)
        Spacer(modifier = Modifier.height(8.dp))
        CharacterDataInfoColumn(
            title = "Episodes Count",
            description = character.episode.size.toString()
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}
