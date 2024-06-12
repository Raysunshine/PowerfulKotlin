package org.raysun.kmp.ui.gallery

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.raysun.kmp.domain.usecase.GetGalleriesUseCase
import org.raysun.kmp.ui.gallery.model.GalleryState

class GalleryScreenModel(
    private val getGalleriesUseCase: GetGalleriesUseCase,
) : StateScreenModel<GalleryState>(GalleryState()) {

    fun doSomething() {
        screenModelScope.launch(Dispatchers.IO) {
            val galleries = async {
                getGalleriesUseCase.invoke()
            }


            println("breakPoint ${galleries.await()}")
        }
    }
}