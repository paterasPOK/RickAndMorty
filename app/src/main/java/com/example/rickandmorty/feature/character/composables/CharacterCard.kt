package com.example.rickandmorty.feature.character.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.characters.Result
import com.example.rickandmorty.base.composables.RickAndMortyImage
import com.example.rickandmorty.base.theme.RickAction
import com.example.rickandmorty.base.theme.RickTextPrimary

@Composable
fun CharacterCard(
    modifier: Modifier,
    result: Result,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(12.dp),
                brush = Brush.verticalGradient(listOf(Color.Transparent, RickAction))
            )
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {

        Box {
            RickAndMortyImage(result.image, context, modifier)
        }
        Text(
            text = result.name,
            color = RickTextPrimary,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 26.sp,
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 6.dp
                )
        )
    }

}