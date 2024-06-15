package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
expect fun ExitReminder(onCloseRequest: () -> Unit = {})

@Composable
expect fun GalleriesFrame(
    modifier: Modifier = Modifier,
    sideBar: @Composable () -> Unit = {},
    body: @Composable (modifier: Modifier) -> Unit = {}
)

@Composable
expect fun SideBarItem(
    modifier: Modifier = Modifier,
    symbol: String,
    icon: ImageVector,
    isSelected: Boolean,
    onItemClick: () -> Unit,
)