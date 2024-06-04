package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import org.raysun.kmp.window.AppWindowState
import org.raysun.kmp.window.WindowType
import kotlin.system.exitProcess

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {
}

actual val platformName: String = "Android"

actual class AppWindowManager actual constructor() {
    actual val windows: SnapshotStateList<AppWindowState> = mutableStateListOf()

    actual fun exit() {
        exitProcess(0)
    }

    actual fun createNewWindow(
        title: String,
        type: WindowType,
        content: @Composable () -> Unit
    ) {
    }

    actual fun removeWindowById(id: String) = true

    actual fun checkIfWindowExists(id: String) = true

}