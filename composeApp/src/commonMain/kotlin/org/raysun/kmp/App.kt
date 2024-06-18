package org.raysun.kmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.navigator.Navigator
import org.koin.compose.koinInject
import org.raysun.kmp.main.MainScreen
import org.raysun.kmp.ui.theme.PowerfulKotlinTheme

@Composable
fun App(
    viewModel: AppViewModel = koinInject(),
) {
    val isDarkTheme = viewModel.isDarkTheme.collectAsState().value

    PowerfulKotlinTheme(
        isDarkTheme = isDarkTheme
    ) {
        Navigator(
            MainScreen()
        )
    }
}