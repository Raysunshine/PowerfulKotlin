package org.raysun.kmp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.raysun.kmp.remote.KtorHotKeyApi
import org.raysun.kmp.ui.gallery.GalleryScreenModel

fun initKoin() {
    startKoin {
        modules(
            platformModule,
            networkModule,
        )
    }
}

expect val platformModule: Module

private val networkModule = module {
    single {
        HttpClient(get()) {

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "www.wanandroid.com"
                }
            }

            install(Logging) {
                level = LogLevel.ALL
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 15_000
                connectTimeoutMillis = 15_000
                socketTimeoutMillis = 15_000
            }

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

    single {
        KtorHotKeyApi(get())
    }

    factoryOf(::GalleryScreenModel)
}