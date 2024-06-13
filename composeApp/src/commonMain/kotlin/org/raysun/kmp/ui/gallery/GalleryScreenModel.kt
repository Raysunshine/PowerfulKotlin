package org.raysun.kmp.ui.gallery

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.raysun.kmp.domain.usecase.GetGalleriesUseCase
import org.raysun.kmp.ui.gallery.model.GalleryState

class GalleryScreenModel(
    private val getGalleriesUseCase: GetGalleriesUseCase,
) : StateScreenModel<GalleryState>(GalleryState()) {

    init {
        screenModelScope.launch(Dispatchers.IO) {
            val galleries = async {
                getGalleriesUseCase.invoke()
            }
            mutableState.update {
                it.copy(
                    picList = galleries.await()
                )
            }
        }
    }
}