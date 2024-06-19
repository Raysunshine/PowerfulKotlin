package org.raysun.kmp.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.raysun.kmp.ui.component.DetailEmptyCard

@Composable
fun DetailScreen(
    screenModel: DetailScreenModel,
) {
    val uiState = screenModel.state.collectAsState().value

    uiState.takeIf {
        it != null
    }?.let {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            KamelImage(
                resource = asyncPainterResource(data = uiState?.primaryImageSmall ?: ""),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(400.dp)
            )
        }
    } ?: run {
        DetailEmptyCard(modifier = Modifier.fillMaxSize())
    }


}