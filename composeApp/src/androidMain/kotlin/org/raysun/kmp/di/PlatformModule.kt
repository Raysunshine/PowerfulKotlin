package org.raysun.kmp.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.raysun.kmp.platform.AppWindowManager

val platformModule = module {
    singleOf(::AppWindowManager)
}