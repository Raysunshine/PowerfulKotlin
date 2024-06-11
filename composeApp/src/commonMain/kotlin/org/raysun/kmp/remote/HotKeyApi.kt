package org.raysun.kmp.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import org.raysun.kmp.network.HotKey
import org.raysun.kmp.network.Result
import org.raysun.kmp.network.ResultWrapper
import org.raysun.kmp.network.fetch

interface HotKeyApi {

    suspend fun getHotKey(): ResultWrapper<List<HotKey>>?
}

class KtorHotKeyApi(private val client: HttpClient) : HotKeyApi {
    override suspend fun getHotKey(): ResultWrapper<List<HotKey>>? {
        val result = client.fetch<ResultWrapper<List<HotKey>>> {
            method = HttpMethod.Get
            url("/hotkey/json")
        }
        return when (result) {
            is Result.Error -> null
            Result.Loading -> null
            is Result.Success -> result.value
        }
    }

}