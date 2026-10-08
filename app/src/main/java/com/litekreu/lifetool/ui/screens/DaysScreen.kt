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
import com.litekreu.lifetool.ui.components.DayItem
import com.litekreu.lifetool.R
import com.litekreu.lifetool.ui.theme.googleSansFamily

@Composable
fun DaysScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = stringResource(R.string.days_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium,
            fontFamily = googleSansFamily
        )
        DayItem(day = 3)
        DayItem(day = 2)
        DayItem(day = 1)
        DayItem()
    }
}