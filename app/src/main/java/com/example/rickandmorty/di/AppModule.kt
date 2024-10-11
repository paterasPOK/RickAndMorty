package com.example.rickandmorty.di

import com.example.rickandmorty.feature.character.viewmodels.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::CharactersViewModel)
}