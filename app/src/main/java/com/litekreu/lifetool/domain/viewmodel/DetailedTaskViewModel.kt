package com.litekreu.lifetool.domain.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.litekreu.lifetool.data.repo.TaskRepository
import com.litekreu.lifetool.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailedTaskViewModel @Inject constructor(
    taskRepo: TaskRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _route = savedStateHandle.toRoute<Routes.DayDetailed>()
    val state = taskRepo.getTaskById(_route.taskId).stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), null
    )
}