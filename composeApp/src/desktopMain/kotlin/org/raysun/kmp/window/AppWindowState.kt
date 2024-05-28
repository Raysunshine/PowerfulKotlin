package org.raysun.kmp.window

import androidx.compose.runtime.Composable
import java.util.UUID

const val MAIN_ID = "MAIN_ID"

enum class WindowType {
    COMMON,
    DIALOG;
}

class AppWindowState(
    val id: String = UUID.randomUUID().toString(),
    val type: WindowType,
    val title: String,
    private val close: (AppWindowState) -> Unit,
    val exit: (() -> Unit)? = null,
    val content: @Composable () -> Unit,
) {

    val isMainWindow = id == MAIN_ID

    fun close() = close(this)
}