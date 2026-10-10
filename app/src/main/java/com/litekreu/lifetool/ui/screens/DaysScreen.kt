package com.litekreu.lifetool.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.litekreu.lifetool.ui.components.DayItem
import com.litekreu.lifetool.R
import com.litekreu.lifetool.navigation.Routes

@Composable
fun DaysScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = stringResource(R.string.days_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium,
        )
        DayItem(day = 3, onClick = { navController.navigate(Routes.DayDetailed(3)) })
        DayItem(day = 2, onClick = { navController.navigate(Routes.DayDetailed(2)) })
        DayItem(day = 1, onClick = { navController.navigate(Routes.DayDetailed(1)) })
        DayItem(onClick = {})
    }
}