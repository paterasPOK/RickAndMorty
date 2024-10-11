package com.example.rickandmorty.base.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.base.theme.RickAction
import com.example.rickandmorty.base.theme.RickTextPrimary

@Composable
fun CharacterDataInfoColumn(
    title: String,
    description: String
) {
    Column {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = RickAction
        )

        Text(
            text = description,
            fontSize = 24.sp,
            color = RickTextPrimary
        )
    }

}