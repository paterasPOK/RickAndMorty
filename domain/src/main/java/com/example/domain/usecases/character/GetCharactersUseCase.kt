package com.example.domain.usecases.character

import com.example.domain.models.characters.Character
import com.example.domain.models.network.NetworkResponse
import com.example.domain.repositories.character.GetCharactersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetCharactersUseCase(
    private val getCharactersRepository: GetCharactersRepository
) {
    val charactersFlow = getCharactersRepository.charactersFlow

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getCharacters()
        }
    }

    suspend fun getCharacters(): NetworkResponse<Character> {
        return getCharactersRepository.getCharacters()
    }
}