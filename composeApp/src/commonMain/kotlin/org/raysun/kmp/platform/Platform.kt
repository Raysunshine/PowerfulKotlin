package org.raysun.kmp.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.raysun.kmp.domain.resp.Galleries

@Composable
expect fun ExitReminder(onCloseRequest: () -> Unit = {})

@Composable
expect fun GalleriesFrame(
    modifier: Modifier = Modifier,
    tabNavigator: TabNavigator,
    sideBarItems: List<Tab>,
    body: @Composable (modifier: Modifier) -> Unit = {},
)

@Composable
expect fun SideBarItem(
    modifier: Modifier = Modifier,
    symbol: String,
    icon: Painter,
    isSelected: Boolean,
    onItemClick: () -> Unit,
)

expect fun showDetailInWindow(detail: Galleries)