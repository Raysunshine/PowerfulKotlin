package org.raysun.kmp.ui.component

import KottieAnimation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.raysun.kmp.data.constant.ResourceConstant
import powerfulkotlin.composeapp.generated.resources.Res
import utils.KottieConstants

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GalleryLoadingCard(modifier: Modifier = Modifier) {
    var animation by remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        animation = Res.readBytes(ResourceConstant.GALLERY_LOADING_LOTTIE).decodeToString()
    }

    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = composition,
        speed = 2.5F,
        iterations = KottieConstants.IterateForever
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        KottieAnimation(
            composition = composition,
            progress = { animationState.progress },
            modifier = Modifier.fillMaxSize()
        )
    }
}