package org.raysun.kmp.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.raysun.kmp.platform.GalleriesFrame
import org.raysun.kmp.ui.component.PowerfulKotlinTab

class MainScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(
            tab = PowerfulKotlinTab.GalleryTab,
            disposeNestedNavigators = false,
        ) {
            val tabNavigator = LocalTabNavigator.current

            GalleriesFrame(
                modifier = Modifier.background(Color(0xFF202020)),
                tabNavigator = tabNavigator,
                sideBarItems = listOf(
                    PowerfulKotlinTab.GalleryTab,
                    PowerfulKotlinTab.DetailTab(),
                    PowerfulKotlinTab.SettingsTab,
                ),
            ) { screenModifier ->
                Box(modifier = screenModifier) {
                    CurrentScreen()
                }
            }
        }
    }
}