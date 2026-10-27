package com.litekreu.lifetool.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.litekreu.lifetool.domain.viewmodel.DetailedTaskViewModel

@Composable
fun DayDetailedScreen(
    modifier: Modifier = Modifier,
    detailedTaskViewModel: DetailedTaskViewModel = hiltViewModel()
) {
    val task by detailedTaskViewModel.state.collectAsStateWithLifecycle()

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = task?.title ?: "Not loaded", style = MaterialTheme.typography.headlineMedium)
        Text("ID: ${task?.id}")
    }
}