package com.litekreu.lifetool.data.repo

import com.litekreu.lifetool.data.dao.TaskDao
import com.litekreu.lifetool.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val taskDao: TaskDao): TaskRepository {
    override fun getAllTasks(): Flow<List<TaskEntity>> = taskDao.getAllTasks()
    override fun getTaskById(id: Int): Flow<TaskEntity?> = taskDao.getTaskById(id)
}