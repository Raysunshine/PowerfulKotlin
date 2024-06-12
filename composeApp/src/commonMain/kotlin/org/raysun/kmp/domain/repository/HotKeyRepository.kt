package org.raysun.kmp.domain.repository

import org.raysun.kmp.domain.resp.ApiResult
import org.raysun.kmp.domain.resp.HotKey

interface HotKeyRepository {

    suspend fun getHotKey(): ApiResult<List<HotKey>>
}