package com.example.data.base.network

internal data class BackendURLs(
    val baseURL: String
) {
    companion object {
        fun getBackendBaseUrl() = BackendURLs(
            baseURL = "https://rickandmortyapi.com/api/"
        )
    }
}