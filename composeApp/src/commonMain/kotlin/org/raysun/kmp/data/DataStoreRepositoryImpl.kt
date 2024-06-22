package org.raysun.kmp.data

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import com.russhwolf.settings.set
import kotlinx.serialization.ExperimentalSerializationApi
import org.raysun.kmp.domain.repository.DataStoreRepository
import org.raysun.kmp.main.model.DetailDisplayMode

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
class DataStoreRepositoryImpl(
    private val settings: Settings,
) : DataStoreRepository {


    override fun storeIsDarkTheme(isDarkTheme: Boolean) {
        settings[IS_DARK_THEME] = isDarkTheme
    }

    override fun getIsDarkTheme(): Boolean {
        return settings.getBoolean(IS_DARK_THEME, false)
    }

    override fun storeDetailDisplayMode(displayMode: DetailDisplayMode) {
        settings.encodeValue(DetailDisplayMode.serializer(), DETAIL_DISPLAY_MODE, displayMode)
    }

    override fun getDetailDisplayMode(): DetailDisplayMode {
        return settings.decodeValueOrNull(DetailDisplayMode.serializer(), DETAIL_DISPLAY_MODE)
            ?: DetailDisplayMode.DETAIL_MODULE
    }

    private companion object {
        const val IS_DARK_THEME = "is_dark_theme"

        const val DETAIL_DISPLAY_MODE = "detail_display_mode"
    }


}