package com.litekreu.lifetool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.litekreu.lifetool.navigation.Routes
import com.litekreu.lifetool.ui.screens.DayDetailedScreen
import com.litekreu.lifetool.ui.screens.DaysScreen
import com.litekreu.lifetool.ui.theme.LifetoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifetoolTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                label = {
                                    Text(stringResource(R.string.days_bottom_bar))
                                },
                                icon = {
                                    Icon(Icons.Default.DateRange,contentDescription = stringResource(R.string.days_bottom_bar))
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.surfaceContainer
                    ) {
                        MainScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Days) {
        composable<Routes.Days> {
            DaysScreen(navController = navController, modifier)
        }
        composable<Routes.DayDetailed> { entry ->
            val route = entry.toRoute<Routes.DayDetailed>()
            DayDetailedScreen(dayId = route.dayId, modifier)
        }
    }
}
