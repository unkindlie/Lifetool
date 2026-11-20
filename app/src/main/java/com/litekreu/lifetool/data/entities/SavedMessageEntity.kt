package com.litekreu.lifetool.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("saved_messages")
data class SavedMessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String
)
