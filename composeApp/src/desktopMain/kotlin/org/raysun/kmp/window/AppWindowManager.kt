package org.raysun.kmp.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.util.fastAny

object AppWindowManager {
    private const val MAIN_TITLE = "Powerful Kotlin Desktop"

    val windows: SnapshotStateList<AppWindowState> = mutableStateListOf()

    init {
        windows += AppWindowState(
            id = MAIN_ID,
            title = MAIN_TITLE,
            type = WindowType.MAIN,
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
        windows += AppWindowState(
            title = title,
            type = type,
            close = windows::remove,
            content = content,
        )
    }

    fun removeWindowById(id: String): Boolean = windows.removeAll { it.id == id }

    fun checkIfWindowExists(id: String): Boolean = windows.fastAny { it.id == id }

    fun checkIfWindowExists(type: WindowType): Boolean = windows.fastAny { it.type == type }

    fun removeWindowByType(type: WindowType) = windows.removeAll { it.type == type }
}