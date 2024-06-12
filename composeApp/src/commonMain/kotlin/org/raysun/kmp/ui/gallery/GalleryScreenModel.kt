package org.raysun.kmp.ui.gallery

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.raysun.kmp.domain.usecase.GetHotKeyUseCase
import org.raysun.kmp.ui.gallery.model.GalleryState

class GalleryScreenModel(
    private val getHotKeyUseCase: GetHotKeyUseCase,
) : StateScreenModel<GalleryState>(GalleryState()) {

    fun doSomething() {
        screenModelScope.launch(Dispatchers.IO) {
            val result = getHotKeyUseCase.invoke()
            println("${result.errorMsg} ${result.data?.firstOrNull()?.name}  ${result.errorCode}")
        }
    }
}