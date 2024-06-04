package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.util.fastAny
import org.raysun.kmp.window.AppWindowState
import org.raysun.kmp.window.MAIN_ID
import org.raysun.kmp.window.WindowType

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {

}

actual val platformName: String = "Desktop"

actual class AppWindowManager actual constructor() {
    actual val windows: SnapshotStateList<AppWindowState> = mutableStateListOf()

    init {
        windows += AppWindowState(
            id = MAIN_ID,
            title = MAIN_TITLE,
            type = WindowType.COMMON,
            exit = ::exit,
            close = windows::remove,
        ) {}
    }

    actual fun exit() = windows.clear()

    actual fun createNewWindow(
        title: String,
        type: WindowType,
        content: @Composable () -> Unit
    ) {
        windows += AppWindowState(
            title = title,
            type = type,
            close = windows::remove,
            content = content,
        )
    }

    actual fun removeWindowById(id: String): Boolean = windows.removeAll { it.id == id }


    actual fun checkIfWindowExists(id: String): Boolean = windows.fastAny { it.id == id }

    companion object {

        private const val MAIN_TITLE = "Powerful Kotlin Desktop"
    }

}