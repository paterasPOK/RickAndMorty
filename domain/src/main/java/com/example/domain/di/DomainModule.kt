package com.example.domain.di

import com.example.domain.usecases.character.GetCharactersUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetCharactersUseCase)
}