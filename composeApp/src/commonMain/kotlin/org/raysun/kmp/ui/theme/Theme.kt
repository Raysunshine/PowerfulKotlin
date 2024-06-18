package org.raysun.kmp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightScheme = lightColors(
    primary = primaryLight,
    primaryVariant = primaryContainerLight,
    secondary = secondaryLight,
    secondaryVariant = secondaryContainerLight,
    background = backgroundLight,
    surface = surfaceLight,
    error = errorLight,
    onPrimary = onPrimaryLight,
    onSecondary = onSecondaryLight,
    onBackground = onBackgroundLight,
    onSurface = onSurfaceLight,
    onError = onErrorLight,
)

private val darkScheme = darkColors(
    primary = primaryDark,
    primaryVariant = primaryContainerDark,
    secondary = secondaryDark,
    secondaryVariant = secondaryContainerDark,
    background = backgroundDark,
    surface = surfaceDark,
    error = errorDark,
    onPrimary = onPrimaryDark,
    onSecondary = onSecondaryDark,
    onBackground = onBackgroundDark,
    onSurface = onSurfaceDark,
    onError = onErrorDark,
)

@Composable
fun PowerfulKotlinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colors = colorScheme,
        typography = AppTypography,
        content = content
    )
}

