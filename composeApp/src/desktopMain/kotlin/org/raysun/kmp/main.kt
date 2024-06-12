package org.raysun.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.raysun.kmp.di.initKoin

fun main() {
    initKoin()

    return application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "PowerfulKotlin",
        ) {
            App()
        }
    }
}