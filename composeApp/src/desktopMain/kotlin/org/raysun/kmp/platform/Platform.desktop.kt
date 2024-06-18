package org.raysun.kmp.platform

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource
import org.raysun.kmp.components.SideBarItemIndicator
import org.raysun.kmp.domain.resp.Galleries
import org.raysun.kmp.window.AppWindowManager
import org.raysun.kmp.window.WindowType
import powerfulkotlin.composeapp.generated.resources.Res
import powerfulkotlin.composeapp.generated.resources.compose_multiplatform

@Composable
actual fun ExitReminder(onCloseRequest: () -> Unit) {
}

@Composable
actual fun GalleriesFrame(
    modifier: Modifier,
    tabNavigator: TabNavigator,
    sideBarItems: List<Tab>,
    body: @Composable (modifier: Modifier) -> Unit,
) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            sideBarItems.forEachIndexed { index, tab ->
                if (index == sideBarItems.lastIndex) {
                    Spacer(modifier = Modifier.weight(1F))
                }
                val isSelected = tabNavigator.current.options.index == tab.options.index
                SideBarItem(
                    symbol = tab.options.title,
                    icon = tab.options.icon ?: painterResource(Res.drawable.compose_multiplatform),
                    isSelected = tabNavigator.current.options.index == tab.options.index,
                ) {
                    if (isSelected) return@SideBarItem

                    tabNavigator.current = tab
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight().width(0.5.dp))
        body(Modifier.weight(1F))
    }
}

@Composable
actual fun SideBarItem(
    modifier: Modifier,
    symbol: String,
    icon: Painter,
    isSelected: Boolean,
    onItemClick: () -> Unit,
) {
    val hoverInteractionSource = remember { MutableInteractionSource() }
    val isHovered by hoverInteractionSource.collectIsHoveredAsState()

    val itemBackground = if (isSelected || isHovered) MaterialTheme.colors.primaryVariant else Color.Transparent

    Row(
        modifier = modifier
            .width(200.dp)
            .hoverable(interactionSource = hoverInteractionSource)
            .clickable { onItemClick() }
            .padding(horizontal = 6.dp, vertical = 2.dp)
            .background(color = itemBackground, shape = RoundedCornerShape(4.dp))
            .padding(vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SideBarItemIndicator(visible = isSelected)
        Spacer(modifier = Modifier.width(6.dp))
        Icon(icon, modifier = Modifier.size(16.dp), contentDescription = null, tint = Color.Unspecified)
        Spacer(modifier = Modifier.width(12.dp))
        Text(symbol, color = MaterialTheme.colors.onBackground, fontSize = 14.sp)
    }
}

actual fun showDetailInWindow(detail: Galleries) {
    AppWindowManager.createNewWindow(
        title = detail.title ?: "",
        type = WindowType.COMMON,
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                KamelImage(
                    resource = asyncPainterResource(data = detail.primaryImage ?: ""),
                    contentDescription = null,
                    modifier = Modifier.width(500.dp),
                    contentScale = ContentScale.FillWidth,
                )
                Spacer(modifier = Modifier.weight(1F))
            }
        }
    )
}

@Composable
actual fun DetailDialogFrame(
    modifier: Modifier,
    detailImage: @Composable () -> Unit,
    detailDescription: @Composable (enterTransition: EnterTransition) -> Unit,
) {
    Row(
        modifier = Modifier.wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        detailImage()

        detailDescription(
            slideInHorizontally(
                animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
            )
        )
    }
}