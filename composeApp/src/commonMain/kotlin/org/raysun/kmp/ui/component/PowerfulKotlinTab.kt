package org.raysun.kmp.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.painterResource
import org.raysun.kmp.domain.resp.Galleries
import org.raysun.kmp.feature.detail.DetailScreen
import org.raysun.kmp.feature.detail.DetailScreenModel
import org.raysun.kmp.feature.detail.model.DetailScreenAction
import org.raysun.kmp.feature.gallery.GalleryScreen
import org.raysun.kmp.feature.settings.SettingsScreen
import powerfulkotlin.composeapp.generated.resources.Res
import powerfulkotlin.composeapp.generated.resources.icon_detail
import powerfulkotlin.composeapp.generated.resources.icon_gallery
import powerfulkotlin.composeapp.generated.resources.icon_settings

sealed class PowerfulKotlinTab {
    object GalleryTab : Tab {
        @Composable
        override fun Content() {
            GalleryScreen()
        }

        override val options: TabOptions
            @Composable
            get() {
                val title = "展览"
                val icon = painterResource(Res.drawable.icon_gallery)

                return remember {
                    TabOptions(
                        index = 0U,
                        title = title,
                        icon = icon,
                    )
                }
            }
    }

    data class DetailTab(
        private val detail: Galleries? = null,
    ) : Tab {
        @Composable
        override fun Content() {
            val screenModel: DetailScreenModel = rememberScreenModel<DetailScreenModel> {
                DetailScreenModel()
            }
            if (detail != null) with(detail) {
                screenModel.onAction(DetailScreenAction.OnGalleriesChanged(this))
            }
            DetailScreen(screenModel = screenModel)
        }

        override val options: TabOptions
            @Composable
            get() {
                val title = "详情"
                val icon = painterResource(Res.drawable.icon_detail)

                return remember {
                    TabOptions(
                        index = 1U,
                        title = title,
                        icon = icon,
                    )
                }
            }
    }

    object SettingsTab : Tab {
        @Composable
        override fun Content() {
            SettingsScreen()
        }

        override val options: TabOptions
            @Composable
            get() {
                val title = "设置"
                val icon = painterResource(Res.drawable.icon_settings)

                return remember {
                    TabOptions(
                        index = 2U,
                        title = title,
                        icon = icon,
                    )
                }
            }
    }
}