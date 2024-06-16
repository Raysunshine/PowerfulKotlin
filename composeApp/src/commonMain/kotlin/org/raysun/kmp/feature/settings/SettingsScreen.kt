package org.raysun.kmp.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text("hello SettingsScreen", color = Color.White)
    }
}