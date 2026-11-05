package com.litekreu.lifetool.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.litekreu.lifetool.R
import com.litekreu.lifetool.domain.viewmodel.TaskViewModel
import com.litekreu.lifetool.navigation.Routes
import com.litekreu.lifetool.ui.components.TaskItem
import com.litekreu.lifetool.ui.components.days.TaskCreationSheet

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun DaysScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel = hiltViewModel<TaskViewModel>(),
) {
    val state by taskViewModel.state.collectAsState()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Text(
                text = stringResource(R.string.days_title),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Medium
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showSheet = true
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        modifier = modifier.padding(horizontal = 18.dp),
    ) {
        if (showSheet) {
            TaskCreationSheet(
                onCreate = { title ->
                    taskViewModel.addTask(title)
                },
                onDismiss = { showSheet = false }
            )
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceContainer
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 52.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.tasks) { task ->
                    TaskItem(
                        task = task,
                        onClick = { navController.navigate(Routes.DayDetailed(task.id)) }
                    )
                }
            }
        }
    }
}