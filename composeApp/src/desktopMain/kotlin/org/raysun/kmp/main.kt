package org.raysun.kmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.raysun.kmp.di.initKoin
import org.raysun.kmp.utils.setMinimumSize
import org.raysun.kmp.window.AppWindowManager
import org.raysun.kmp.window.WindowType

fun main() {
    initKoin()

    return application {
        for (window in AppWindowManager.windows) {
            key(window) {
                when (window.type) {
                    WindowType.MAIN -> {
                        Window(
                            title = window.title,
                            state = rememberWindowState(
                                position = WindowPosition(alignment = Alignment.Center)
                            ),
                            onCloseRequest = { window.exit?.invoke() ?: exitApplication() },
                        ) {
                            this.window.setMinimumSize(DpSize(1024.dp, 768.dp))

                            App()
                        }
                    }

                    WindowType.COMMON -> {
                        Window(
                            title = window.title,
                            resizable = false,
                            state = rememberWindowState(
                                position = WindowPosition(alignment = Alignment.Center)
                            ),
                            onCloseRequest = window::close,
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                window.content()
                            }
                        }
                    }

                    WindowType.DIALOG -> {
                        DialogWindow(
                            title = window.title,
                            resizable = false,
                            onCloseRequest = window::close,
                        ) {
                            window.content()
                        }
                    }
                }
            }
        }
    }
}
