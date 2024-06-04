package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import org.raysun.kmp.window.AppWindowState
import org.raysun.kmp.window.WindowType

@Composable
expect fun ExitReminder(onCloseRequest: () -> Unit)

expect val platformName: String

expect class AppWindowManager() {

    val windows: SnapshotStateList<AppWindowState>

    fun exit()

    fun createNewWindow(
        title: String,
        type: WindowType,
        content: @Composable () -> Unit,
    )

    fun removeWindowById(id: String): Boolean

    fun checkIfWindowExists(id: String): Boolean
}

object Platform {
    fun isDesktop() = platformName == "Desktop"
    fun isAndroid() = platformName == "Android"
    fun isIOS() = platformName == "IOS"
}