package com.example.data.repositories.character.network

import com.example.data.base.CharacterEndpoints
import com.example.domain.models.characters.Character
import retrofit2.Response
import retrofit2.http.GET

internal interface CharacterApiService {

    @GET(CharacterEndpoints.characters)
    suspend fun getCharacters(): Response<Character>
}