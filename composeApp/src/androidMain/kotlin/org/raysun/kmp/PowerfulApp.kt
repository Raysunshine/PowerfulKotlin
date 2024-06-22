package org.raysun.kmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.raysun.kmp.di.initKoin

class PowerfulApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@PowerfulApp)
        }
    }
}