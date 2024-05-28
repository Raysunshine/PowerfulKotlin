package org.raysun.kmp.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf

class AppWindowManager {

    val windows = mutableStateListOf<AppWindowState>()

    init {
        windows += AppWindowState(
            id = MAIN_ID,
            title = MAIN_TITLE,
            type = WindowType.COMMON,
            exit = ::exit,
            close = windows::remove,
        ) {}
    }

    fun exit() = windows.clear()

    fun createNewWindow(
        title: String,
        type: WindowType,
        content: @Composable () -> Unit,
    ) {
        windows += commonWindowState(title = title, type = type, content = content)
    }

    private fun commonWindowState(
        title: String,
        type: WindowType,
        content: @Composable () -> Unit,
    ) = AppWindowState(
        title = title,
        type = type,
        close = windows::remove,
        content = content,
    )

    companion object {

        private const val MAIN_TITLE = "Powerful Kotlin Desktop"
    }
}