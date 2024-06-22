package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.DataStoreRepository

class StoreDarkThemeUseCase(
    private val dataStoreRepository: DataStoreRepository,
) {

    operator fun invoke(isDarkTheme: Boolean) = dataStoreRepository.storeIsDarkTheme(isDarkTheme)
}