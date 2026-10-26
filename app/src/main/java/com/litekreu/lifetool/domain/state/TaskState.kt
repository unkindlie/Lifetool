package com.litekreu.lifetool.domain.state

import com.litekreu.lifetool.data.entities.TaskEntity

data class TaskState(
    val tasks: List<TaskEntity> = listOf()
)
