package org.raysun.kmp.di

import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.module.Module


class KoinInit {

    fun koinInit(platformModule: List<Module>): Koin {
        return startKoin {
            modules(
                platformModule,
            )
        }.koin
    }

}
