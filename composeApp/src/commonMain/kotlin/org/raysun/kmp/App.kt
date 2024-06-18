package org.raysun.kmp

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.raysun.kmp.main.MainScreen
import org.raysun.kmp.ui.theme.PowerfulKotlinTheme

@Composable
fun App() {
    PowerfulKotlinTheme {
        Navigator(
            MainScreen()
        )
    }
}