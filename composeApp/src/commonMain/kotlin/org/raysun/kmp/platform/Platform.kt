package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun ExitReminder(onCloseRequest: () -> Unit = {})

@Composable
expect fun GalleriesFrame(
    modifier: Modifier = Modifier,
    sideBar: @Composable () -> Unit = {},
    splitContent: @Composable () -> Unit = {},
    body: @Composable (modifier: Modifier) -> Unit = {}
)