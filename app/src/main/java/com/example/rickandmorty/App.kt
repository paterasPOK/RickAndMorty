package com.example.rickandmorty

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.rickandmorty.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}