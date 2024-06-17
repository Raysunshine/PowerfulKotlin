package org.raysun.kmp.main.model

sealed class MainScreenAction {

    data class OnShowDetailDisplayedInWindowChanged(val newValue: Boolean) : MainScreenAction()
}