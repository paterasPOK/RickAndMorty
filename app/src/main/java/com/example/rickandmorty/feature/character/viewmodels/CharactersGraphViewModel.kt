package com.example.rickandmorty.feature.character.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.characters.Result
import com.example.domain.usecases.character.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharactersGraphViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val character = MutableStateFlow<Result?>(null)

    fun getCharacterById(characterId: Int) {
        viewModelScope.launch {
            getCharactersUseCase.charactersFlow.collect { result ->
                val matchingCharacter = result.find { it.id == characterId }
                character.value = matchingCharacter
            }
        }
    }
}