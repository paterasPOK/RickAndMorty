package com.example.data.repositories.character

import com.example.data.base.executeNetworkCall
import com.example.data.repositories.character.network.CharacterApiService
import com.example.domain.models.characters.Character
import com.example.domain.models.characters.Result
import com.example.domain.models.network.NetworkResponse
import com.example.domain.repositories.character.GetCharactersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

internal class GetCharactersRepositoryImpl(
    private val characterApiService: CharacterApiService
) : GetCharactersRepository {
    override val charactersFlow = MutableStateFlow<List<Result>>(emptyList())
    override suspend fun getCharacters(): NetworkResponse<Character> {
        return executeNetworkCall {
            characterApiService.getCharacters()
        }.also { result ->
            if (result is NetworkResponse.Success) charactersFlow.update {
                result.value?.results ?: emptyList()
            }
        }
    }

}