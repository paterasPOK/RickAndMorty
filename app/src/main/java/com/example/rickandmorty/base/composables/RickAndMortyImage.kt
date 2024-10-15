package com.example.rickandmorty.base.composables

import android.content.Context
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun RickAndMortyImage(
    imageUrl: String,
    context: Context,
    modifier: Modifier
) {
    val imageRequest = remember {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .build()
    }
    SubcomposeAsyncImage(
        model = imageRequest,
        contentDescription = "Character Image",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp))
    )

}