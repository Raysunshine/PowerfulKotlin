package org.raysun.kmp.feature.gallery

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.navigator.LocalNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import org.raysun.kmp.domain.resp.Composition
import org.raysun.kmp.main.MainScreenModel
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.platform.DetailDialogFrame
import org.raysun.kmp.platform.showDetailInWindow
import org.raysun.kmp.ui.component.CompositionGrid
import org.raysun.kmp.ui.component.GalleryLoadingCard
import org.raysun.kmp.ui.component.PowerfulKotlinTab
import org.raysun.kmp.ui.component.PropertyItem

@Composable
fun GalleryScreen(
    screenModel: GalleryScreenModel = koinInject(),
    mainScreenModel: MainScreenModel = koinInject(),
) {

    val localNavigator = LocalNavigator.current

    val uiState = screenModel.state.collectAsState().value
    val newWindowBackground = MaterialTheme.colors.background

    val mainUiState = mainScreenModel.state.collectAsState().value

    var selectedComposition: Composition? by rememberSaveable {
        mutableStateOf(null)
    }

    AnimatedContent(
        uiState.compositionList.isNotEmpty(),
    ) { galleryAvailable ->
        if (galleryAvailable) {
            CompositionGrid(
                compositionList = uiState.compositionList,
                onCompositionClicked = { index ->
                    val composition = uiState.compositionList[index]
                    when (mainUiState.detailDisplayMode) {
                        DetailDisplayMode.NEW_WINDOW -> {
                            showDetailInWindow(
                                modifier = Modifier.background(newWindowBackground),
                                localNavigator,
                                composition
                            )
                        }

                        DetailDisplayMode.NEW_DIALOG -> {
                            selectedComposition = composition
                        }

                        DetailDisplayMode.DETAIL_MODULE -> localNavigator?.push(PowerfulKotlinTab.DetailTab(composition))
                    }
                },
            )
        } else {
            GalleryLoadingCard(modifier = Modifier.fillMaxSize())
        }
    }

    selectedComposition?.run {
        DetailDialog(
            detail = this,
        ) {
            selectedComposition = null
        }
    }
}

@Composable
fun DetailDialog(
    modifier: Modifier = Modifier,
    detail: Composition,
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
                .background(MaterialTheme.colors.surface)
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