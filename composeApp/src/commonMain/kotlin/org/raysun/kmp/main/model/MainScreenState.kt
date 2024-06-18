package org.raysun.kmp.main.model

data class MainScreenState(
    val detailDisplayMode: DetailDisplayMode = DetailDisplayMode.DETAIL_MODULE,
)

enum class DetailDisplayMode {
    NEW_WINDOW, NEW_DIALOG, DETAIL_MODULE,
}