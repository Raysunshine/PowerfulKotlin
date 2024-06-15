package org.raysun.kmp.platform

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.raysun.kmp.components.SideBarItemIndicator

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {
}

@Composable
actual fun GalleriesFrame(
    modifier: Modifier,
    sideBar: @Composable () -> Unit,
    body: @Composable (modifier: Modifier) -> Unit
) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            sideBar()
        }
        Spacer(
            modifier = Modifier.fillMaxHeight().width(0.5.dp).background(Color.LightGray),
        )
        body(Modifier.weight(1F))
    }
}

@Composable
actual fun SideBarItem(
    modifier: Modifier,
    symbol: String,
    icon: ImageVector,
    isSelected: Boolean,
    onItemClick: () -> Unit,
) {
    val itemBackground = if (isSelected) Color(0xFF2D2D2D) else Color.Transparent

    Row(
        modifier = modifier
            .width(200.dp)
            .clickable { onItemClick() }
            .padding(horizontal = 6.dp, vertical = 4.dp)
            .background(color = itemBackground, shape = RoundedCornerShape(4.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SideBarItemIndicator(visible = isSelected)
        Spacer(modifier = Modifier.width(6.dp))
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Text(symbol)
    }
}