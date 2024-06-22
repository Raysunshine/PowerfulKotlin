package org.raysun.kmp.feature.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.raysun.kmp.ui.component.DetailEmptyCard
import org.raysun.kmp.ui.component.PropertyItem

@Composable
fun DetailScreen(
    screenModel: DetailScreenModel,
) {
    val uiState = screenModel.state.collectAsState().value

    uiState.takeIf {
        it != null
    }?.let {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            KamelImage(
                resource = asyncPainterResource(data = uiState?.primaryImageSmall ?: ""),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxHeight(0.5F),
            )

            PropertyItem(
                propertyName = "作品名",
                propertyValue = uiState?.title,
            )
            PropertyItem(
                propertyName = "风格",
                propertyValue = uiState?.department,
            )
            PropertyItem(
                propertyName = "作家",
                propertyValue = uiState?.artistDisplayName,
            )
            PropertyItem(
                propertyName = "创作年份",
                propertyValue = uiState?.objectDate,
            )
            PropertyItem(
                propertyName = "现存博物馆",
                propertyValue = uiState?.repository,
            )
            PropertyItem(
                propertyName = "展览源",
                propertyValue = uiState?.objectURL,
                isHref = true,
            )


        }
    } ?: run {
        DetailEmptyCard(modifier = Modifier.fillMaxSize())
    }


}