package org.raysun.kmp.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import powerfulkotlin.composeapp.generated.resources.Res
import powerfulkotlin.composeapp.generated.resources.icon_cloud
import powerfulkotlin.composeapp.generated.resources.icon_random_dot
import powerfulkotlin.composeapp.generated.resources.icon_starts


private val defaultSwitchHorizontalPadding = 3.dp
private val defaultSwitchVerticalPadding = 5.dp
private val switchWidth = 54.dp
private val switchHeight = 30.dp
private val thumbDiameter = 20.dp

@Composable
fun ColorfulSwitch(
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
) {
    val xOffset = with(LocalDensity.current) {
        (switchWidth - thumbDiameter - defaultSwitchHorizontalPadding * 2).roundToPx()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if (checked) IntOffset(x = xOffset, y = 0) else IntOffset.Zero,
        animationSpec = tween(
            durationMillis = 250,
            easing = LinearEasing,
        ),
    )

    val switchBackgroundColor by animateColorAsState(
        targetValue = if (checked) Color(0xFF3F4D5D) else Color(0xFF7DDFFB),
        animationSpec = tween(
            durationMillis = 150,
            easing = LinearEasing,
        )
    )

    val thumbBackground by animateColorAsState(
        targetValue = if (checked) Color(0xFFC0CCCC) else Color(0xFFF0E054),
        animationSpec = tween(
            durationMillis = 150,
            easing = LinearEasing,
        )
    )

    val defaultSwitchVerticalPaddingInt = with(LocalDensity.current) {
        defaultSwitchHorizontalPadding.roundToPx()
    }

    Box(
        modifier = Modifier
            .size(switchWidth, switchHeight)
            .clip(RoundedCornerShape(switchHeight / 2))
            .background(color = switchBackgroundColor)
            .clickable { onCheckedChanged(!checked) }
            .padding(
                horizontal = defaultSwitchHorizontalPadding,
                vertical = defaultSwitchVerticalPadding,
            ),
    ) {
        Box(
            modifier = Modifier
                .offset { offset }
                .size(thumbDiameter)
                .clip(CircleShape)
                .background(color = thumbBackground)
        ) {
            AnimatedVisibility(
                checked,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icon_random_dot),
                    modifier = Modifier.scale(0.6F),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
        }

        AnimatedVisibility(
            visible = checked,
            modifier = Modifier.align(Alignment.CenterStart),
            enter = slideIn(initialOffset = {
                IntOffset(-it.width, 0)
            }),
            exit = slideOut(targetOffset = {
                IntOffset(-it.width, 0)
            }),
        ) {
            Icon(
                painter = painterResource(Res.drawable.icon_starts),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }

        AnimatedVisibility(
            visible = !checked,
            modifier = Modifier.padding(end = defaultSwitchVerticalPadding).align(Alignment.CenterEnd),
            enter = slideIn(initialOffset = {
                IntOffset(it.width + defaultSwitchVerticalPaddingInt, 0)
            }),
            exit = slideOut(targetOffset = {
                IntOffset(it.width + defaultSwitchVerticalPaddingInt, 0)
            }),
        ) {
            Icon(
                painter = painterResource(Res.drawable.icon_cloud),
                modifier = Modifier.size(width = 16.dp, height = 24.dp),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}