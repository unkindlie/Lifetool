package com.litekreu.lifetool.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.litekreu.lifetool.R

enum class NavRoutes {
    Days,
    Saved
}

data class NavigationItem(
    val label: Int,
    val icon: ImageVector,
    val route: NavRoutes
)

val NavigationItems = listOf(
    NavigationItem( R.string.days_bottom_bar, Icons.Default.DateRange, NavRoutes.Days),
    NavigationItem(R.string.saved_bottom_bar, Icons.Default.Email, NavRoutes.Saved)
)


@Composable
fun AppBottomNavBar(navController: NavHostController) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        NavigationItems.forEachIndexed { i, it -> NavigationBarItem(
            selected = selectedIndex == i,
            onClick = {
                val value = when(it.route) {
                    NavRoutes.Days -> Routes.Days
                    NavRoutes.Saved -> Routes.Saved
                }

                navController.navigate(value) {
                    popUpTo(value)
                    launchSingleTop = true
                    restoreState = true
                }

                selectedIndex = i
            },
            label = { Text(stringResource(it.label)) },
            icon = {
                Icon(
                    it.icon,
                    contentDescription = stringResource(it.label)
                )
            }
        ) }
    }
}