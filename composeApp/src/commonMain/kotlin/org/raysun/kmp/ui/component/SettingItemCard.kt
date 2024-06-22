package org.raysun.kmp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingItemCard(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    symbol: String,
    onCheckedChanged: (Boolean) -> Unit,
    isUsedForDarkMode: Boolean = false,
    descriptionContent: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier.padding(vertical = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                MaterialTheme.colors.surface,
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

                if (isUsedForDarkMode) {
                    ColorfulSwitch(isChecked, onCheckedChanged = onCheckedChanged, thumbAnimationDuration = 200)
                } else {
                    ColorfulSwitch(isChecked, onCheckedChanged = onCheckedChanged)
                }
            }

            descriptionContent()
        }
    }
}