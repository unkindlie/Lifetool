package com.litekreu.lifetool.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("saved_messages")
data class SavedMessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    @ColumnInfo(name = "created_at", defaultValue = "CURRENT_TIMESTAMP")
    val createdAt: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "updated_at", defaultValue = "null")
    val updatedAt: Long? = null
)
