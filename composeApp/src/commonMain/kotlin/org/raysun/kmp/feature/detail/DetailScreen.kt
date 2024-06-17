package org.raysun.kmp.feature.detail

import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun DetailScreen(
    screenModel: DetailScreenModel,
) {
    val uiState = screenModel.state.collectAsState().value

    uiState.takeIf {
        it != null
    }?.let {
        KamelImage(
            resource = asyncPainterResource(data = uiState?.primaryImageSmall ?: ""),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(400.dp)
        )
    } ?: Text("请到展览中选择一张图片")

}