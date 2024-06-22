package org.raysun.kmp.platform

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.resources.painterResource
import org.raysun.kmp.domain.resp.Galleries
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
    Column(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colors.background)
            .statusBarsPadding(),
    ) {
        body(Modifier.weight(1F))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(MaterialTheme.colors.primaryVariant)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            sideBarItems.forEach { tab ->
                SideBarItem(
                    symbol = tab.options.title,
                    icon = tab.options.icon ?: painterResource(resource = Res.drawable.compose_multiplatform),
                    isSelected = tabNavigator.current == tab
                ) {
                    tabNavigator.current = tab
                }
            }
        }
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
    Column(
        modifier = Modifier
            .clickable { onItemClick() }
            .padding(horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(2.dp))
        Icon(icon, modifier = Modifier.size(22.dp), contentDescription = null, tint = Color.Unspecified)
        Spacer(modifier = Modifier.height(1.dp))
        Text(symbol, color = MaterialTheme.colors.onBackground)
        Spacer(modifier = Modifier.height(2.dp))
    }
}

actual fun showDetailInWindow(modifier: Modifier, detail: Galleries) {
}

@Composable
actual fun DetailDialogFrame(
    modifier: Modifier,
    detailImage: @Composable () -> Unit,
    detailDescription: @Composable (enterTransition: EnterTransition) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        detailImage()

        detailDescription(
            slideInVertically(
                animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
            )
        )
    }
}

@Composable
actual fun SettingsFrame(
    modifier: Modifier,
    galleryDetailDisplayModule: LazyListScope.() -> Unit,
    darkThemeModule: LazyListScope.() -> Unit,
) {

    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 12.dp),
    ) {
        Text("设置", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(
            modifier = Modifier.weight(1F)
        ) {
            galleryDetailDisplayModule()

            darkThemeModule()
        }
    }

}