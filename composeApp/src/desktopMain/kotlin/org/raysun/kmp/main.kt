package org.raysun.kmp

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.raysun.kmp.di.initKoin
import org.raysun.kmp.utils.setMinimumSize

fun main() {
    initKoin()

    return application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "PowerfulKotlin",
        ) {
            window.setMinimumSize(DpSize(800.dp, 600.dp))

            App()
        }
    }
}