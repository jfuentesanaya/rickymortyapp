package com.jfuentes.rickymortyapp.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Juan Fuentes on 01/07/2021.
 */

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class GenericError(val code: Int? = null, val error: String? = null) : Result<Nothing>()
    object NetworkError : Result<Nothing>()
}

suspend fun <T> executeService(
    dispatcher: CoroutineDispatcher,
    service: suspend () -> T
): Result<T> {
    return withContext(dispatcher) {
        try {
            Result.Success(service.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Result.NetworkError
                is HttpException -> {
                    Result.GenericError(throwable.code(), throwable.message())
                }
                else -> {
                    Result.GenericError(null, null)
                }
            }
        }
    }
}