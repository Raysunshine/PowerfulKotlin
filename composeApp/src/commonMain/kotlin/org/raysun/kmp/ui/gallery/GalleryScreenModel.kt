package org.raysun.kmp.ui.gallery

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.raysun.kmp.remote.KtorHotKeyApi
import org.raysun.kmp.ui.gallery.model.GalleryState

class GalleryScreenModel(
    private val hotKeyApi: KtorHotKeyApi,
    private val client: HttpClient,
) : StateScreenModel<GalleryState>(GalleryState()) {

    fun doSomething() {
        screenModelScope.launch(Dispatchers.IO) {
            val result = hotKeyApi.getHotKey()
            println("${result?.errorMsg} ${result?.data?.firstOrNull()?.name}  ${result?.errorCode}")
        }
    }
}