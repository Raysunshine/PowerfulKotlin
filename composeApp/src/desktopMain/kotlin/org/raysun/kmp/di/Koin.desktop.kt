package org.raysun.kmp.di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import io.ktor.client.engine.apache.Apache
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.prefs.Preferences

actual val platformModule: Module = module {
    single {
        Apache.create {

        }
    }
    single<Preferences> {
        Preferences.userRoot()
    }
    single<Settings> {
        PreferencesSettings(get())
    }
}