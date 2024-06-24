package org.raysun.kmp.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.raysun.kmp.platform.GalleryFrame
import org.raysun.kmp.ui.component.PowerfulKotlinTab

class MainScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(
            tab = PowerfulKotlinTab.GalleryTab,
            disposeNestedNavigators = false,
        ) {
            val tabNavigator = LocalTabNavigator.current

            GalleryFrame(
                tabNavigator = tabNavigator,
                sideBarItems = listOf(
                    PowerfulKotlinTab.GalleryTab,
                    PowerfulKotlinTab.DetailTab(),
                    PowerfulKotlinTab.SettingsTab,
                ),
            ) { screenModifier ->
                Box(modifier = screenModifier.fillMaxSize().background(MaterialTheme.colors.background)) {
                    CurrentScreen()
                }
            }
        }
    }
}