package org.raysun.kmp.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideBarItemIndicator(visible: Boolean) {
    AnimatedContent(
        targetState = visible,
        transitionSpec = {
            slideInVertically() togetherWith slideOutHorizontally()
        }
    ) { indicatorVisible ->
        val indicatorColor = if (indicatorVisible) MaterialTheme.colors.secondary else Color.Transparent

        Spacer(
            modifier = Modifier
                .width(2.dp)
                .height(15.dp)
                .background(
                    color = indicatorColor,
                    shape = RoundedCornerShape(8.dp)
                )
        )
    }
}