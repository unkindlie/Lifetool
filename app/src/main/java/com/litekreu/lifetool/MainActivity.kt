package com.litekreu.lifetool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.litekreu.lifetool.navigation.AppBottomNavBar
import com.litekreu.lifetool.navigation.Routes
import com.litekreu.lifetool.ui.screens.DayDetailedScreen
import com.litekreu.lifetool.ui.screens.DaysScreen
import com.litekreu.lifetool.ui.screens.SavedScreen
import com.litekreu.lifetool.ui.theme.LifetoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var navController: NavController

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LifetoolTheme {
                navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = { AppBottomNavBar(navController) }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.surfaceContainer
                    ) {
                        MainScreen(navController, modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Routes.Days) {
        composable<Routes.Days> {
            DaysScreen(navController = navController, modifier)
        }
        composable<Routes.DayDetailed> { entry ->
            val route = entry.toRoute<Routes.DayDetailed>()
            DayDetailedScreen(dayId = route.dayId, modifier)
        }
        composable<Routes.Saved> {
            SavedScreen(modifier)
        }
    }
}
