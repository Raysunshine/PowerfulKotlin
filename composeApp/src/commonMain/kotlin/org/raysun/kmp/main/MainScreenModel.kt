package org.raysun.kmp.main

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.update
import org.raysun.kmp.main.model.MainScreenAction
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged
import org.raysun.kmp.main.model.MainScreenState

class MainScreenModel : StateScreenModel<MainScreenState>(MainScreenState()) {

    fun onAction(action: MainScreenAction) = when (action) {
        is OnShowDetailDisplayedInWindowChanged -> changeShowDetailDisplayedInWindowStatus(action.newValue)
    }

    private fun changeShowDetailDisplayedInWindowStatus(newStatus: Boolean) {
        mutableState.update {
            it.copy(
                isDetailDisplayedInWindow = newStatus
            )
        }
    }
}