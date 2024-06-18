package org.raysun.kmp.feature.gallery

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import org.raysun.kmp.domain.resp.Galleries
import org.raysun.kmp.main.MainScreenModel
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.platform.DetailDialogFrame
import org.raysun.kmp.platform.showDetailInWindow
import org.raysun.kmp.ui.component.PowerfulKotlinTab

@Composable
fun GalleryScreen(
    screenModel: GalleryScreenModel = koinInject(),
    mainScreenModel: MainScreenModel = koinInject(),
) {

    val localNavigator = LocalNavigator.current
    val uiState = screenModel.state.collectAsState().value

    val mainUiState = mainScreenModel.state.collectAsState().value

    var selectedGalleries: Galleries? by rememberSaveable {
        mutableStateOf(null)
    }

    AnimatedContent(
        uiState.picList.isNotEmpty(),
    ) { objectsAvailable ->
        if (objectsAvailable) {
            ObjectGrid(objects = uiState.picList, onObjectClick = { index ->
                val selectedPic = uiState.picList[index]
                when (mainUiState.detailDisplayMode) {
                    DetailDisplayMode.NEW_WINDOW -> showDetailInWindow(selectedPic)

                    DetailDisplayMode.NEW_DIALOG -> {
                        selectedGalleries = selectedPic
                    }

                    DetailDisplayMode.DETAIL_MODULE -> localNavigator?.push(PowerfulKotlinTab.DetailTab(selectedPic))
                }
            })
        } else {
            EmptyScreenContent(Modifier.fillMaxSize())
        }
    }

    selectedGalleries?.run {
        DetailDialog(
            detail = this,
        ) {
            selectedGalleries = null
        }
    }
}

@Composable
fun DetailDialog(
    modifier: Modifier = Modifier,
    detail: Galleries,
    onDismissRequest: () -> Unit,
) {

    var isShowDetailInformation by remember { mutableStateOf(false) }

    LaunchedEffect(detail.objectID) {
        delay(200)
        isShowDetailInformation = true
    }

    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        DetailDialogFrame(
            modifier = modifier.wrapContentSize(unbounded = true)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.onSurface)
                .padding(10.dp),
            detailImage = {
                KamelImage(
                    resource = asyncPainterResource(data = detail.primaryImageSmall ?: ""),
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(0.6F).wrapContentSize(),
                    contentScale = ContentScale.Inside,
                )
            },
        ) { enterTransition ->
            AnimatedContent(
                targetState = isShowDetailInformation,
                transitionSpec = {
                    fadeIn() + enterTransition togetherWith fadeOut()
                }
            ) { isShowInformation ->
                Column(
                    modifier = Modifier.width(244.dp).alpha(if (isShowInformation) 1F else 0F)
                ) {
                    PropertyItem(
                        propertyName = "作品名",
                        propertyValue = detail.title,
                    )
                    PropertyItem(
                        propertyName = "风格",
                        propertyValue = detail.department,
                    )
                    PropertyItem(
                        propertyName = "作家",
                        propertyValue = detail.artistDisplayName,
                    )
                    PropertyItem(
                        propertyName = "创作年份",
                        propertyValue = detail.objectDate,
                    )
                    PropertyItem(
                        propertyName = "现存博物馆",
                        propertyValue = detail.repository,
                    )
                    PropertyItem(
                        propertyName = "展览源",
                        propertyValue = detail.objectURL,
                    )
                }
            }
        }
    }
}

@Composable
fun PropertyItem(
    modifier: Modifier = Modifier,
    propertyName: String,
    propertyValue: String?,
) {
    Row(
        modifier = modifier.padding(vertical = 2.dp),
    ) {
        Text("$propertyName : ", color = MaterialTheme.colors.onBackground)
        Text(propertyValue ?: "未知", color = MaterialTheme.colors.onBackground)
    }
}

@Composable
private fun ObjectGrid(
    objects: List<Galleries>,
    onObjectClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp), modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)
    ) {
        itemsIndexed(objects, key = { _, it -> it.objectID ?: 0 }) { index, obj ->
            ObjectFrame(
                obj = obj,
                onClick = { onObjectClick(index) },
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

@Composable
fun EmptyScreenContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text("No data available", color = MaterialTheme.colors.onBackground)
    }
}