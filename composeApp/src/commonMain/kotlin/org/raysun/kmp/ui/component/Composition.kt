package org.raysun.kmp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.raysun.kmp.domain.resp.Composition


@Composable
fun CompositionGrid(
    compositionList: List<Composition>,
    onCompositionClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp), modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)
    ) {
        itemsIndexed(compositionList, key = { _, it -> it.objectID ?: 0 }) { index, obj ->
            CompositionFrame(
                obj = obj,
                onClick = { onCompositionClicked(index) },
            )
        }
    }
}

@Composable
private fun CompositionFrame(
    obj: Composition,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(8.dp).clickable { onClick() }) {
        KamelImage(
            resource = asyncPainterResource(data = obj.primaryImageSmall ?: ""),
            contentDescription = obj.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            obj.title ?: "",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            obj.artistDisplayName ?: "",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body2
        )
        Text(
            obj.objectDate ?: "", color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.caption
        )
    }
}