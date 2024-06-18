package org.raysun.kmp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel {
    var isDarkTheme = MutableStateFlow(false)
        private set

    fun changeAppTheme(isDarkTheme: Boolean) {
        this.isDarkTheme.update {
            isDarkTheme
        }
    }
}