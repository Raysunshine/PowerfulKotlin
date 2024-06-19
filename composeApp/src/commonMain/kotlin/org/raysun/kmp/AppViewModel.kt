package org.raysun.kmp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.raysun.kmp.platform.IS_DARK_THEME
import org.raysun.kmp.platform.settings

class AppViewModel {
    var isDarkTheme = MutableStateFlow(false)
        private set

    init {
        isDarkTheme.update {
            settings.getBoolean(IS_DARK_THEME, false)
        }
    }

    fun changeAppTheme(isDarkTheme: Boolean) {
        this.isDarkTheme.update {
            isDarkTheme
        }.also {
            settings.putBoolean(IS_DARK_THEME, isDarkTheme)
        }
    }
}