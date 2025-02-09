package org.raysun.kmp.platform

import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.raysun.kmp.domain.resp.Composition

@Composable
expect fun ExitReminder(onCloseRequest: () -> Unit = {})

@Composable
expect fun GalleryFrame(
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

expect fun showDetailInWindow(
    modifier: Modifier,
    localNavigator: Navigator? = null,
    detail: Composition,
)

@Composable
expect fun DetailDialogFrame(
    modifier: Modifier = Modifier,
    detailImage: @Composable () -> Unit = {},
    detailDescription: @Composable (enterTransition: EnterTransition) -> Unit = {},
)

@Composable
expect fun SettingsFrame(
    modifier: Modifier = Modifier,
    galleryDetailDisplayModule: LazyListScope.() -> Unit,
    darkThemeModule: LazyListScope.() -> Unit,
)