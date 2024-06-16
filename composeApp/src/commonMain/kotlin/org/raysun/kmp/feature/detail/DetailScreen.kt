package org.raysun.kmp.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DetailScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text("hello Detail", color = Color.White)
    }
}