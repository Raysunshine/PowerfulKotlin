package org.raysun.kmp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.raysun.kmp.domain.usecase.GetDarkThemeUseCase
import org.raysun.kmp.domain.usecase.StoreDarkThemeUseCase

class AppViewModel(
    private val getDarkThemeUseCase: GetDarkThemeUseCase,
    private val storeDarkThemeUseCase: StoreDarkThemeUseCase,
) {
    var isDarkTheme = MutableStateFlow(false)
        private set

    init {
        isDarkTheme.update {
            getDarkThemeUseCase.invoke()
        }
    }

    fun changeAppTheme(isDarkTheme: Boolean) {
        this.isDarkTheme.update {
            isDarkTheme
        }.also {
            storeDarkThemeUseCase.invoke(isDarkTheme = isDarkTheme)
        }
    }
}