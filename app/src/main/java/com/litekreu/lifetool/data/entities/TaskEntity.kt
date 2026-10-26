package com.litekreu.lifetool.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String
)