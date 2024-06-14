package org.raysun.kmp.platform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
    Row(modifier = modifier.fillMaxSize()) {
        Column {
            sideBar()
        }
        splitContent()
        body(Modifier.weight(1F))
    }
}