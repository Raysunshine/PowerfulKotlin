package org.raysun.kmp.feature.detail

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.update
import org.raysun.kmp.domain.resp.Composition
import org.raysun.kmp.feature.detail.model.DetailScreenAction

class DetailScreenModel : StateScreenModel<Composition?>(initialState = null) {

    fun onAction(action: DetailScreenAction) {
        when (action) {
            is DetailScreenAction.OnCompositionChanged -> onCompositionChanged(action.detail)
        }
    }

    private fun onCompositionChanged(detail: Composition) {
        mutableState.update {
            detail
        }
    }
}