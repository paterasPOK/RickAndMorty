package com.example.domain.repositories.character

import com.example.domain.models.characters.Character
import com.example.domain.models.characters.Result
import com.example.domain.models.network.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface GetCharactersRepository {
    val charactersFlow: Flow<List<Result>>
    suspend fun getCharacters(): NetworkResponse<Character>
}