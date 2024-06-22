package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.DataStoreRepository

class GetDarkThemeUseCase(
    private val dataStoreRepository: DataStoreRepository,
) {

    operator fun invoke(): Boolean = dataStoreRepository.getIsDarkTheme()
}