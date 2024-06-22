package org.raysun.kmp.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PropertyItem(
    modifier: Modifier = Modifier,
    propertyName: String,
    propertyValue: String?,
) {
    Row(
        modifier = modifier.padding(vertical = 2.dp),
    ) {
        Text("$propertyName : ", color = MaterialTheme.colors.onBackground)
        Text(propertyValue ?: "未知", color = MaterialTheme.colors.onBackground)
    }
}