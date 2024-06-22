package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.DataStoreRepository
import org.raysun.kmp.main.model.DetailDisplayMode

class StoreDetailDisplayModeUseCase(
    private val dataStoreRepository: DataStoreRepository,
) {

    operator fun invoke(displayMode: DetailDisplayMode) = dataStoreRepository.storeDetailDisplayMode(displayMode)
}