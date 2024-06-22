package org.raysun.kmp.feature.settings

import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject
import org.raysun.kmp.AppViewModel
import org.raysun.kmp.main.MainScreenModel
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged
import org.raysun.kmp.platform.SettingsFrame
import org.raysun.kmp.ui.component.SettingItemCard

@Composable
fun SettingsScreen(
    mainScreenModel: MainScreenModel = koinInject(),
    appViewModel: AppViewModel = koinInject(),
) {
    val isDarkTheme = appViewModel.isDarkTheme.collectAsState().value

    val uiState = mainScreenModel.state.collectAsState().value

    SettingsFrame(
        galleryDetailDisplayModule = {
            item {
                Text("展览详情展示方式", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h6)
            }

            items(DetailDisplayMode.entries.toTypedArray()) {
                SettingItemCard(
                    isChecked = uiState.detailDisplayMode == it,
                    symbol = it.symbol,
                    onCheckedChanged = { isChecked ->
                        if (isChecked) {
                            mainScreenModel.onAction(OnShowDetailDisplayedInWindowChanged(it))
                        }
                    }
                ) {
                    it.description.forEach { description ->
                        Text(description, color = MaterialTheme.colors.onBackground)
                    }
                }
            }
        },
        darkThemeModule = {
            item {
                Text("深色模式", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h6)
            }

            item {
                SettingItemCard(
                    isChecked = isDarkTheme,
                    symbol = "深色模式",
                    isUsedForDarkMode = true,
                    onCheckedChanged = { isChecked ->
                        appViewModel.changeAppTheme(isChecked)
                    }
                ) {
                    Text(
                        "开启后，将开启深色模式，若关闭，则为默认的白色模式",
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    )
}
