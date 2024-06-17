package org.raysun.kmp.feature.detail

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.update
import org.raysun.kmp.domain.resp.Galleries
import org.raysun.kmp.feature.detail.model.DetailScreenAction

class DetailScreenModel : StateScreenModel<Galleries?>(initialState = null) {

    fun onAction(action: DetailScreenAction) {
        when (action) {
            is DetailScreenAction.OnGalleriesChanged -> onGalleriesChanged(action.detail)
        }
    }

    private fun onGalleriesChanged(detail: Galleries) {
        mutableState.update {
            detail
        }
    }
}