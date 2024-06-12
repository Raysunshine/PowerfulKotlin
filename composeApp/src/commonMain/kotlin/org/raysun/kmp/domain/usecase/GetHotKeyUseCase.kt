package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.HotKeyRepository
import org.raysun.kmp.domain.resp.ApiResult
import org.raysun.kmp.domain.resp.HotKey

class GetHotKeyUseCase(
    private val hotKeyRepository: HotKeyRepository,
) {

    suspend operator fun invoke(): ApiResult<List<HotKey>> {
        return hotKeyRepository.getHotKey()
    }
}