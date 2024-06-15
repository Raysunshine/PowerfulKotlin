package org.raysun.kmp.ui.gallery

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.raysun.kmp.domain.resp.Galleries
import org.raysun.kmp.platform.GalleriesFrame
import org.raysun.kmp.platform.SideBarItem

class GalleryScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<GalleryScreenModel>()

        val uiState = screenModel.state.collectAsState()

        GalleriesFrame(
            sideBar = {
                SideBarItem(
                    symbol = "首页",
                    icon = Icons.Default.Home
                )
                SideBarItem(
                    symbol = "详情",
                    icon = Icons.Default.Create
                )
            },
        ) { bodyModifier ->
            AnimatedContent(
                uiState.value.picList.isNotEmpty(),
                modifier = bodyModifier,
            ) { objectsAvailable ->
                if (objectsAvailable) {
                    ObjectGrid(
                        objects = uiState.value.picList,
                        onObjectClick = { objectId ->
                            println("OnObjectClick -> $objectId")
                        }
                    )
                } else {
                    EmptyScreenContent(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
private fun ObjectGrid(
    objects: List<Galleries>,
    onObjectClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(objects, key = { it.objectID ?: 0 }) { obj ->
            ObjectFrame(
                obj = obj,
                onClick = { onObjectClick(obj.objectID ?: 0) },
            )
        }
    }
}

@Composable
private fun ObjectFrame(
    obj: Galleries,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        KamelImage(
            resource = asyncPainterResource(data = obj.primaryImageSmall ?: ""),
            contentDescription = obj.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.LightGray),
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(obj.title ?: "", style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold))
        Text(obj.artistDisplayName ?: "", style = MaterialTheme.typography.body2)
        Text(obj.objectDate ?: "", style = MaterialTheme.typography.caption)
    }
}

@Composable
fun EmptyScreenContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text("No data available")
    }
}