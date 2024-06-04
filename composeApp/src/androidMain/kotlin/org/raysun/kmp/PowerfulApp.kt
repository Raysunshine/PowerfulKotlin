package org.raysun.kmp

import android.app.Application
import org.raysun.kmp.di.KoinInit
import org.raysun.kmp.di.platformModule

class PowerfulApp : Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInit().koinInit(
            listOf(
                platformModule
            )
        )
    }
}