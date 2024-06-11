package org.raysun.kmp

import android.app.Application
import org.raysun.kmp.di.initKoin

class PowerfulApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}