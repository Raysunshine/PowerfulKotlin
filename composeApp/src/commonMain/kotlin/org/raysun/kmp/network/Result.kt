package org.raysun.kmp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode

sealed interface Result<out R> {

    class Success<out R>(val value: R) : Result<R>

    data object Loading : Result<Nothing>

    class Error(val throwable: Throwable) : Result<Nothing>
}

suspend inline fun <reified T> HttpClient.fetch(
    block: HttpRequestBuilder.() -> Unit
): Result<T> = try {
    val response = request(block)
    if (response.status == HttpStatusCode.OK) {
        Result.Success(response.body())
    } else {
        Result.Error(Throwable("${response.status}:${response.bodyAsText()}"))
    }
} catch (e: Exception) {
    Result.Error(e)
}