package com.litekreu.lifetool.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.litekreu.lifetool.ui.components.DayItem
import com.litekreu.lifetool.R
import com.litekreu.lifetool.domain.viewmodel.TaskViewModel
import com.litekreu.lifetool.navigation.Routes

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun DaysScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel = hiltViewModel<TaskViewModel>(),
) {
    val list = remember { (13 downTo 1).toList() }

    val state by taskViewModel.state.collectAsState()

    Scaffold(
        topBar = {
            Text(
                text = stringResource(R.string.days_title),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Medium,
            )
        },
        modifier = Modifier.padding(top = 48.dp, start = 18.dp, end = 18.dp)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceContainer
        ) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.tasks) { task ->
                    Text(task.title)
                }
            }
        }
    }
}