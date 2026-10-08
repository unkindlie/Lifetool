package com.litekreu.lifetool.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.litekreu.lifetool.ui.theme.googleSansFamily

@Composable
fun DayDetailedScreen(dayId: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Day $dayId", fontFamily = googleSansFamily, style = MaterialTheme.typography.headlineMedium)
    }
}