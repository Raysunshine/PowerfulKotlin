package org.raysun.kmp.ui.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GalleryScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<GalleryScreenModel>()

        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                screenModel.doSomething()
            }
        }

        Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("What")
            }
        }) {
            Button(
                onClick = {}
            ) {
                Text("Clicked to request new pic", color = Color.Black)
            }
        }
    }
}