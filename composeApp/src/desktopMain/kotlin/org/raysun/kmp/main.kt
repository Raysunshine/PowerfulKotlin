package org.raysun.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.raysun.kmp.di.initKoin
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun main() {
    initKoin()

    LoggerFactory.getLogger("123")
    return application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "PowerfulKotlin",
        ) {
            App()
        }
    }
}