package org.raysun.kmp.di

import android.content.Context
import android.content.SharedPreferences
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        OkHttp.create {

        }
    }
    single<SharedPreferences> {
        get<Context>().getSharedPreferences("data_store", Context.MODE_PRIVATE)
    }
    single<Settings> {
        SharedPreferencesSettings(delegate = get())
    }

}