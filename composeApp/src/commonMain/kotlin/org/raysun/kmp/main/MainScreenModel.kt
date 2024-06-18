package org.raysun.kmp.main

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.update
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.main.model.MainScreenAction
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged
import org.raysun.kmp.main.model.MainScreenState

class MainScreenModel : StateScreenModel<MainScreenState>(MainScreenState()) {

    fun onAction(action: MainScreenAction) = when (action) {
        is OnShowDetailDisplayedInWindowChanged -> changeShowDetailDisplayedInWindowStatus(action.newMode)
    }

    private fun changeShowDetailDisplayedInWindowStatus(newMode: DetailDisplayMode) {
        mutableState.update {
            it.copy(
                detailDisplayMode = newMode
            )
        }
    }
}