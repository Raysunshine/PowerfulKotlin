package org.raysun.kmp.main

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.update
import org.raysun.kmp.domain.usecase.GetDetailDisplayModeUseCase
import org.raysun.kmp.domain.usecase.StoreDetailDisplayModeUseCase
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.main.model.MainScreenAction
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged
import org.raysun.kmp.main.model.MainScreenState

class MainScreenModel(
    getDetailDisplayModeUseCase: GetDetailDisplayModeUseCase,
    private val storeDetailDisplayModeUseCase: StoreDetailDisplayModeUseCase,
) : StateScreenModel<MainScreenState>(MainScreenState()) {

    init {
        getDetailDisplayModeUseCase.invoke().let {
            mutableState.update { state ->
                state.copy(
                    detailDisplayMode = it
                )
            }
        }
    }

    fun onAction(action: MainScreenAction) = when (action) {
        is OnShowDetailDisplayedInWindowChanged -> changeShowDetailDisplayedInWindowStatus(action.newMode)
    }

    private fun changeShowDetailDisplayedInWindowStatus(newMode: DetailDisplayMode) {
        mutableState.update {
            it.copy(
                detailDisplayMode = newMode
            )
        }.also {
            storeDetailDisplayModeUseCase.invoke(displayMode = newMode)
        }
    }
}