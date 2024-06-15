package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {
}

@Composable
actual fun GalleriesFrame(
    modifier: Modifier,
    sideBar: @Composable () -> Unit,
    body: @Composable (modifier: Modifier) -> Unit
) {
}

@Composable
actual fun SideBarItem(
    modifier: Modifier,
    symbol: String,
    icon: ImageVector
) {
}