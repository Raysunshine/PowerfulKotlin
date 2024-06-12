package org.raysun.kmp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.raysun.kmp.domain.repository.HotKeyRepository
import org.raysun.kmp.domain.resp.ApiResult
import org.raysun.kmp.domain.resp.HotKey

class HotKeyRepositoryImpl(
    private val httpClient: HttpClient,
) : HotKeyRepository {
    override suspend fun getHotKey(): ApiResult<List<HotKey>> = httpClient.get("hotkey/json").body()

}