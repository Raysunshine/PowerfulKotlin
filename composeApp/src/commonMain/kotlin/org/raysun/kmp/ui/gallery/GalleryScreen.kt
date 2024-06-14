package org.raysun.kmp.ui.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.raysun.kmp.platform.GalleriesFrame

class GalleryScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<GalleryScreenModel>()

        val uiState = screenModel.state.collectAsState()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) {
            GalleriesFrame(
                sideBar = {
                    Button(
                        onClick = {}
                    ) {
                        Text("Icons1")
                    }

                    Button(
                        onClick = {}
                    ) {
                        Text("Icons2")
                    }
                },
                splitContent = {
                    Spacer(modifier = Modifier.height(20.dp).fillMaxWidth().background(Color.Blue))
                }
            ) { bodyModifier ->
                LazyColumn(modifier = bodyModifier) {
                    items(50) {
                        Text("Hello $it")
                    }
                }
            }
        }
    }
}