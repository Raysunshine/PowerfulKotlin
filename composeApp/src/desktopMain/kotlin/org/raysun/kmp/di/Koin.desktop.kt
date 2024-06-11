package org.raysun.kmp.di

import io.ktor.client.engine.apache.Apache
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        Apache.create {

        }
    }
}