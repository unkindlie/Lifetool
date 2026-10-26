package com.litekreu.lifetool.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.litekreu.lifetool.data.dao.TaskDao
import com.litekreu.lifetool.data.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class LifetoolDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
}