package com.litekreu.lifetool.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litekreu.lifetool.data.repo.TaskRepository
import com.litekreu.lifetool.domain.state.TaskState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    taskRepo: TaskRepository
): ViewModel() {
    private val _tasks = taskRepo.getAllTasks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())
    private val _state = MutableStateFlow(TaskState())

    val state = combine(_tasks, _state) { tasks, state ->
        state.copy(
            tasks = tasks
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(10000), TaskState())
}