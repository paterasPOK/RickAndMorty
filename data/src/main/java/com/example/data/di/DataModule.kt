package com.example.data.di

import com.example.data.base.network.BackendURLs
import com.example.data.repositories.character.GetCharactersRepositoryImpl
import com.example.data.repositories.character.network.CharacterApiService
import com.example.domain.repositories.character.GetCharactersRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BackendURLs.getBackendBaseUrl().baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApiService::class.java)
    }

    singleOf(::GetCharactersRepositoryImpl) bind GetCharactersRepository::class
}