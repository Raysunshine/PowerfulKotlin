package org.raysun.kmp

import androidx.compose.runtime.key
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.raysun.kmp.di.KoinInit
import org.raysun.kmp.di.platformModule
import org.raysun.kmp.platform.AppWindowManager
import org.raysun.kmp.window.WindowType

fun main() {
    val koin = KoinInit().koinInit(
        listOf(platformModule)
    )

    val windowManagerInstance: AppWindowManager = koin.get<AppWindowManager>()

    return application {
        val windowManager = rememberSaveable { windowManagerInstance }
        for (window in windowManager.windows) {
            key(window) {
                when (window.type) {
                    WindowType.MAIN -> {
                        Window(
                            onCloseRequest = { window.exit?.invoke() ?: exitApplication() },
                            title = window.title,
                        ) {
                            App()
                        }
                    }

                    WindowType.COMMON -> {
                        Window(
                            onCloseRequest = window::close,
                            title = window.title,
                        ) {
                            window.content()
                        }
                    }

                    WindowType.DIALOG -> {
                        DialogWindow(
                            alwaysOnTop = true,
                            onCloseRequest = window::close
                        ) {
                            window.content()
                        }
                    }
                }
            }
        }
    }
}