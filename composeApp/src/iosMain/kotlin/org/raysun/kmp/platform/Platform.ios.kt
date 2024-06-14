package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {
}

@Composable
actual fun GalleriesFrame(
    modifier: Modifier,
    sideBar: @Composable () -> Unit,
    splitContent: @Composable () -> Unit,
    body: @Composable (modifier: Modifier) -> Unit
) {
}