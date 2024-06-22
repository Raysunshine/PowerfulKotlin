package org.raysun.kmp.domain.repository

import org.raysun.kmp.main.model.DetailDisplayMode

interface DataStoreRepository {

    fun storeIsDarkTheme(isDarkTheme: Boolean)

    fun getIsDarkTheme(): Boolean

    fun storeDetailDisplayMode(displayMode: DetailDisplayMode)

    fun getDetailDisplayMode(): DetailDisplayMode
}