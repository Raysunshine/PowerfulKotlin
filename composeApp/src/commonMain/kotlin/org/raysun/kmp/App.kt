package org.raysun.kmp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.raysun.kmp.ui.gallery.GalleryScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(
            GalleryScreen()
        )
    }
}