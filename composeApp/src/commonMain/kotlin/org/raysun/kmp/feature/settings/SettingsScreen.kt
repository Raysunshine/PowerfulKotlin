package org.raysun.kmp.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import org.raysun.kmp.AppViewModel
import org.raysun.kmp.main.MainScreenModel
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged
import org.raysun.kmp.ui.component.ColorfulSwitch

@Composable
fun SettingsScreen(
    mainScreenModel: MainScreenModel = koinInject(),
    appViewModel: AppViewModel = koinInject(),
) {
    val isDarkTheme = appViewModel.isDarkTheme.collectAsState().value

    val uiState = mainScreenModel.state.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 12.dp),
    ) {
        Text("设置", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            LazyColumn(
                modifier = Modifier.weight(1F)
            ) {
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
            }

            Spacer(modifier = Modifier.width(20.dp))

            LazyColumn(
                modifier = Modifier.weight(1F)
            ) {
                item {
                    Text("", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.subtitle1)
                }

                item {
                    SettingItemCard(
                        modifier = Modifier.weight(1F),
                        isChecked = isDarkTheme,
                        symbol = "深色模式",
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

        }
    }
}

@Composable
fun SettingItemCard(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    symbol: String,
    onCheckedChanged: (Boolean) -> Unit,
    descriptionContent: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier.padding(vertical = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(6.dp),
            ).padding(10.dp),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(symbol, color = MaterialTheme.colors.onBackground)

                ColorfulSwitch(isChecked, onCheckedChanged = onCheckedChanged)
            }

            descriptionContent()
        }
    }
}