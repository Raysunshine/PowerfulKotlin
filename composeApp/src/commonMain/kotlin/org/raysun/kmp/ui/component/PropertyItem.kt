package org.raysun.kmp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun PropertyItem(
    modifier: Modifier = Modifier,
    propertyName: String,
    propertyValue: String?,
    isHref: Boolean = false,
) {
    val uriHandler = if (isHref) LocalUriHandler.current else null
    val propertyValueDecoration = if (isHref) TextDecoration.Underline else null

    Row(
        modifier = modifier.padding(vertical = 2.dp),
    ) {
        Text("$propertyName : ", color = MaterialTheme.colors.onBackground)
        Text(
            propertyValue ?: "未知",
            textDecoration = propertyValueDecoration,
            modifier = Modifier.clickable(isHref) {
                uriHandler?.openUri(propertyValue ?: "未知")
            },
            color = MaterialTheme.colors.onBackground,
        )
    }
}