package org.raysun.kmp.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import org.raysun.kmp.AppViewModel
import org.raysun.kmp.main.MainScreenModel
import org.raysun.kmp.main.model.DetailDisplayMode
import org.raysun.kmp.main.model.MainScreenAction.OnShowDetailDisplayedInWindowChanged

@Composable
fun SettingsScreen(
    mainScreenModel: MainScreenModel = koinInject(),
    appViewModel: AppViewModel = koinInject(),
) {
    val isDarkTheme = appViewModel.isDarkTheme.collectAsState().value

    val uiState = mainScreenModel.state.collectAsState().value

    var currentDetailDisplayMode by rememberSaveable {
        mutableStateOf(uiState.detailDisplayMode)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CheckBoxWithText(
            isChecked = currentDetailDisplayMode == DetailDisplayMode.NEW_WINDOW,
            symbol = "NEW_WINDOW"
        ) { isChecked ->
            if (isChecked) {
                currentDetailDisplayMode = DetailDisplayMode.NEW_WINDOW
            }
        }

        CheckBoxWithText(
            isChecked = currentDetailDisplayMode == DetailDisplayMode.NEW_DIALOG,
            symbol = "NEW_DIALOG"
        ) { isChecked ->
            if (isChecked) {
                currentDetailDisplayMode = DetailDisplayMode.NEW_DIALOG
            }
        }

        CheckBoxWithText(
            isChecked = currentDetailDisplayMode == DetailDisplayMode.DETAIL_MODULE,
            symbol = "DETAIL_MODULE"
        ) { isChecked ->
            if (isChecked) {
                currentDetailDisplayMode = DetailDisplayMode.DETAIL_MODULE
            }
        }

        Button(
            onClick = {
                mainScreenModel.onAction(OnShowDetailDisplayedInWindowChanged(currentDetailDisplayMode))
            }
        ) {
            Text("确认")
        }

        CheckBoxWithText(
            isChecked = isDarkTheme,
            symbol = "ChangeTheme"
        ) { isChecked ->
            appViewModel.changeAppTheme(isChecked)
        }
    }
}

@Composable
fun CheckBoxWithText(isChecked: Boolean, symbol: String, onCheckedChanged: (Boolean) -> Unit) {
    Row {
        Checkbox(isChecked, onCheckedChange = onCheckedChanged)
        Text(symbol, color = MaterialTheme.colors.onBackground)
    }
}