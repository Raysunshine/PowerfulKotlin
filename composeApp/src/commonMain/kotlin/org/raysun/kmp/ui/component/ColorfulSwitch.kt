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
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
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


@Stable
interface ColorfulSwitchColors {

    @Composable
    fun backgroundColor(checked: Boolean): State<Color>


    @Composable
    fun thumbColor(checked: Boolean): State<Color>
}

@Immutable
private class DefaultColorfulSwitchColors(
    private val backgroundColor: Color,
    private val thumbColor: Color,
    private val unCheckedBackgroundColor: Color,
    private val unCheckedThumbColor: Color,
) : ColorfulSwitchColors {

    @Composable
    override fun backgroundColor(checked: Boolean): State<Color> {
        return rememberUpdatedState(if (checked) backgroundColor else unCheckedBackgroundColor)
    }

    @Composable
    override fun thumbColor(checked: Boolean): State<Color> {
        return rememberUpdatedState(if (checked) thumbColor else unCheckedThumbColor)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as DefaultColorfulSwitchColors

        if (backgroundColor != other.backgroundColor) return false
        if (thumbColor != other.thumbColor) return false
        if (unCheckedBackgroundColor != other.unCheckedBackgroundColor) return false
        if (unCheckedThumbColor != other.unCheckedThumbColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = backgroundColor.hashCode()
        result = 31 * result + thumbColor.hashCode()
        result = 31 * result + unCheckedBackgroundColor.hashCode()
        result = 31 * result + unCheckedThumbColor.hashCode()
        return result
    }
}

object ColorfulSwitchDefaults {

    val defaultSwitchHorizontalPadding = 3.dp
    val defaultSwitchVerticalPadding = 5.dp
    val switchWidth = 54.dp
    val switchHeight = 28.dp
    val thumbDiameter = 20.dp
    const val SWITCH_CHECK_DURATION = 250

    @Composable
    fun colorfulSwitchColors(
        backgroundColor: Color = MaterialTheme.colors.onSurface,
        thumbColor: Color = MaterialTheme.colors.onSecondary,
        unCheckedBackgroundColor: Color = MaterialTheme.colors.secondary,
        unCheckedThumbColor: Color = MaterialTheme.colors.secondaryVariant,
    ): ColorfulSwitchColors = DefaultColorfulSwitchColors(
        backgroundColor = backgroundColor,
        thumbColor = thumbColor,
        unCheckedBackgroundColor = unCheckedBackgroundColor,
        unCheckedThumbColor = unCheckedThumbColor,
    )
}

@Composable
fun ColorfulSwitch(
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    colors: ColorfulSwitchColors = ColorfulSwitchDefaults.colorfulSwitchColors(),
) {

    val switchBackgroundColor = colors.backgroundColor(checked = checked)

    val thumbColor = colors.thumbColor(checked = checked)

    val xOffset = with(LocalDensity.current) {
        (ColorfulSwitchDefaults.switchWidth - ColorfulSwitchDefaults.thumbDiameter - ColorfulSwitchDefaults.defaultSwitchHorizontalPadding * 2).roundToPx()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if (checked) IntOffset(x = xOffset, y = 0) else IntOffset.Zero,
        animationSpec = tween(
            durationMillis = ColorfulSwitchDefaults.SWITCH_CHECK_DURATION,
            easing = LinearEasing,
        ),
    )

    Box(
        modifier = Modifier.size(ColorfulSwitchDefaults.switchWidth, ColorfulSwitchDefaults.switchHeight)
            .clip(RoundedCornerShape(ColorfulSwitchDefaults.switchHeight / 2))
            .background(color = switchBackgroundColor.value).clickable { onCheckedChanged(!checked) }.padding(
                horizontal = ColorfulSwitchDefaults.defaultSwitchHorizontalPadding,
                vertical = ColorfulSwitchDefaults.defaultSwitchVerticalPadding,
            ),
    ) {
        Box(
            modifier = Modifier
                .offset { offset }
                .size(ColorfulSwitchDefaults.thumbDiameter)
                .clip(CircleShape)
                .background(color = thumbColor.value)
        )
    }


}

@Composable
fun ColorfulSwitch(
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    thumbAnimationDuration: Int,
) {
    val xOffset = with(LocalDensity.current) {
        (ColorfulSwitchDefaults.switchWidth - ColorfulSwitchDefaults.thumbDiameter - ColorfulSwitchDefaults.defaultSwitchHorizontalPadding * 2).roundToPx()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if (checked) IntOffset(x = xOffset, y = 0) else IntOffset.Zero,
        animationSpec = tween(
            durationMillis = thumbAnimationDuration,
            easing = LinearEasing,
        ),
    )

    val switchBackgroundColor by animateColorAsState(
        targetValue = if (checked) Color(0xFF3F4D5D) else Color(0xFF7DDFFB), animationSpec = tween(
            durationMillis = thumbAnimationDuration,
            easing = LinearEasing,
        )
    )

    val thumbBackground by animateColorAsState(
        targetValue = if (checked) Color(0xFFC0CCCC) else Color(0xFFF0E054), animationSpec = tween(
            durationMillis = thumbAnimationDuration,
            easing = LinearEasing,
        )
    )

    val defaultSwitchVerticalPaddingInt = with(LocalDensity.current) {
        ColorfulSwitchDefaults.defaultSwitchHorizontalPadding.roundToPx()
    }

    Box(
        modifier = Modifier.size(ColorfulSwitchDefaults.switchWidth, ColorfulSwitchDefaults.switchHeight)
            .clip(RoundedCornerShape(ColorfulSwitchDefaults.switchHeight / 2))
            .background(color = switchBackgroundColor).clickable { onCheckedChanged(!checked) }.padding(
                horizontal = ColorfulSwitchDefaults.defaultSwitchHorizontalPadding,
                vertical = ColorfulSwitchDefaults.defaultSwitchVerticalPadding,
            ),
    ) {
        Box(
            modifier = Modifier.offset { offset }
                .size(ColorfulSwitchDefaults.thumbDiameter)
                .clip(CircleShape)
                .background(color = thumbBackground),
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
            enter = slideIn(
                animationSpec = tween(
                    durationMillis = thumbAnimationDuration,
                    easing = LinearEasing,
                ),
                initialOffset = {
                    IntOffset(-it.width, 0)
                },
            ),
            exit = slideOut(
                animationSpec = tween(
                    durationMillis = thumbAnimationDuration,
                    easing = LinearEasing,
                ),
                targetOffset = {
                    IntOffset(-it.width, 0)
                },
            ),
        ) {
            Icon(
                painter = painterResource(Res.drawable.icon_starts),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }

        AnimatedVisibility(
            visible = !checked,
            modifier = Modifier.padding(end = ColorfulSwitchDefaults.defaultSwitchVerticalPadding)
                .align(Alignment.CenterEnd),
            enter = slideIn(
                animationSpec = tween(
                    durationMillis = thumbAnimationDuration,
                    easing = LinearEasing,
                ),
                initialOffset = {
                    IntOffset(it.width + defaultSwitchVerticalPaddingInt, 0)
                },
            ),
            exit = slideOut(
                animationSpec = tween(
                    durationMillis = thumbAnimationDuration,
                    easing = LinearEasing,
                ),
                targetOffset = {
                    IntOffset(it.width + defaultSwitchVerticalPaddingInt, 0)
                },
            ),
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