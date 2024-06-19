package org.raysun.kmp.main

import cafe.adriel.voyager.core.model.StateScreenModel
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import kotlinx.coroutines.flow.update
import kotlinx.serialization.ExperimentalSerializationApi
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.main.model.MainScreenAction
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged
import org.raysun.kmp.main.model.MainScreenState
import org.raysun.kmp.platform.DETAIL_DISPLAY_MODE
import org.raysun.kmp.platform.settings

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
class MainScreenModel : StateScreenModel<MainScreenState>(MainScreenState()) {

    init {
        settings.decodeValueOrNull(DetailDisplayMode.serializer(), DETAIL_DISPLAY_MODE)?.let {
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
            settings.encodeValue(DetailDisplayMode.serializer(), DETAIL_DISPLAY_MODE, newMode)
        }
    }
}