package com.example.rickandmorty.feature.character.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.character.GetCharactersUseCase

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
    val charactersListResultState = getCharactersUseCase.charactersFlow
}