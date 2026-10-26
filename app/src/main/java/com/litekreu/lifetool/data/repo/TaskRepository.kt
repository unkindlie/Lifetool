package com.litekreu.lifetool.data.repo

import com.litekreu.lifetool.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<TaskEntity>>

    fun getTaskById(id: Int): Flow<TaskEntity?>
}