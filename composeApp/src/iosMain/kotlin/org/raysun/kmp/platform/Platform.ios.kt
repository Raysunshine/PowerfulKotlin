package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {
}

@Composable
actual fun GalleriesFrame(
    modifier: Modifier,
    tabNavigator: TabNavigator,
    sideBarItems: List<Tab>,
    body: @Composable (modifier: Modifier) -> Unit
) {
}

@Composable
actual fun SideBarItem(
    modifier: Modifier,
    symbol: String,
    icon: Painter,
    isSelected: Boolean,
    onItemClick: () -> Unit,
) {
}