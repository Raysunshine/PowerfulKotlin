package org.raysun.kmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.raysun.kmp.domain.resp.Composition

data class GalleryDetailScreen(
    private val detail: Composition,
) : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .statusBarsPadding(),
            backgroundColor = Color.Black,
        ) {
            KamelImage(
                resource = asyncPainterResource(data = detail.primaryImageSmall ?: ""),
                contentDescription = null,
                modifier = Modifier.padding(it),
            )
        }
    }
}