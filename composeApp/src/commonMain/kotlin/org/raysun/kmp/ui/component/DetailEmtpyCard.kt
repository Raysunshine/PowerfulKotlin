package org.raysun.kmp.ui.component

import KottieAnimation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import powerfulkotlin.composeapp.generated.resources.Res
import utils.KottieConstants


@OptIn(ExperimentalResourceApi::class)
@Composable
fun DetailEmptyCard(modifier: Modifier = Modifier) {
    var animation by remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        animation = Res.readBytes("plurals/details_empty_lottie.json").decodeToString()
    }

    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = composition,
        speed = 2.5F,
        iterations = KottieConstants.IterateForever
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        KottieAnimation(
            composition = composition,
            progress = { animationState.progress },
            modifier = Modifier.fillMaxSize(0.8F)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "请在[设置]中勾选[详情页]，并在[展览]中挑选一张图片",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h5
        )
    }
}