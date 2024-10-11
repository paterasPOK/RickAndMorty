package com.example.data.base

import com.example.domain.models.network.NetworkResponse
import retrofit2.Response

internal suspend fun <T> executeNetworkCall(
    networkCall: suspend () -> Response<T>?
): NetworkResponse<T> {
    return try {
        val response = networkCall()
        if (response?.isSuccessful == true) {
            NetworkResponse.Success(response.body())
        } else {
            NetworkResponse.Failure(
                code = response?.code().toString(),
                message = response?.message().toString()
            )
        }
    } catch (e: Exception) {
        NetworkResponse.NetworkFailure(code = "", message = "NetworkError: ${e.message.toString()}")
    }
}