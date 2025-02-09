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
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.raysun.kmp.AppViewModel
import org.raysun.kmp.data.DataStoreRepositoryImpl
import org.raysun.kmp.data.MuseumRepositoryImpl
import org.raysun.kmp.domain.repository.DataStoreRepository
import org.raysun.kmp.domain.repository.MuseumRepository
import org.raysun.kmp.domain.usecase.GetCompositionUseCase
import org.raysun.kmp.domain.usecase.GetDarkThemeUseCase
import org.raysun.kmp.domain.usecase.GetDetailDisplayModeUseCase
import org.raysun.kmp.domain.usecase.StoreDarkThemeUseCase
import org.raysun.kmp.domain.usecase.StoreDetailDisplayModeUseCase
import org.raysun.kmp.feature.detail.DetailScreenModel
import org.raysun.kmp.feature.gallery.GalleryScreenModel
import org.raysun.kmp.main.MainScreenModel

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
            platformModule,
            networkModule,
            repositoryModule,
            useCaseModule,
            screenModelModule,
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
                    host = "raw.githubusercontent.com"
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
}

private val repositoryModule = module {
    single<MuseumRepository> { MuseumRepositoryImpl(get()) }
    single<DataStoreRepository> { DataStoreRepositoryImpl(get()) }
}

private val useCaseModule = module {
    singleOf(::GetCompositionUseCase)
    singleOf(::GetDarkThemeUseCase)
    singleOf(::StoreDarkThemeUseCase)
    singleOf(::GetDetailDisplayModeUseCase)
    singleOf(::StoreDetailDisplayModeUseCase)
}

private val screenModelModule = module {
    singleOf(::AppViewModel)
    singleOf(::GalleryScreenModel)
    singleOf(::DetailScreenModel)
    singleOf(::MainScreenModel)
}