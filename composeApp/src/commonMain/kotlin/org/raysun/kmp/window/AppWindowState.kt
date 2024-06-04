package org.raysun.kmp.window

import androidx.compose.runtime.Composable

const val MAIN_ID = "MAIN_ID"

enum class WindowType {
    MAIN,
    COMMON,
    DIALOG;
}

class AppWindowState(
    val id: String? = null,
    val type: WindowType,
    val title: String,
    private val close: (AppWindowState) -> Unit,
    val exit: (() -> Unit)? = null,
    val content: @Composable () -> Unit,
) {

    val isMainWindow = type == WindowType.MAIN

    fun close() = close(this)
}