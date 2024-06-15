package org.raysun.kmp.utils

import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.unit.DpSize
import java.awt.Dimension

fun ComposeWindow.setMinimumSize(size: DpSize) {
    minimumSize = Dimension(size.width.value.toInt(), size.height.value.toInt())
}