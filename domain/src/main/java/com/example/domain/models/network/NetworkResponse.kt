package com.example.domain.models.network

sealed class NetworkResponse<out T> {
    data class Success<out T>(
        val value: T?
    ) : NetworkResponse<T>()

    data class Failure(
        val code: String,
        val message: String
    ) : NetworkResponse<Nothing>()

    data class NetworkFailure(
        val code: String,
        val message: String
    ) : NetworkResponse<Nothing>()
}
