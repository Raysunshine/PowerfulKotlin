package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.DataStoreRepository
import org.raysun.kmp.main.model.DetailDisplayMode

class GetDetailDisplayModeUseCase(
    private val dataStoreRepository: DataStoreRepository,
) {

    operator fun invoke(): DetailDisplayMode = dataStoreRepository.getDetailDisplayMode()
}