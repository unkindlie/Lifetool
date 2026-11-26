package com.litekreu.lifetool.data.dto.messages

data class SavedMessageUpdateDto(
    val id: Int,
    val text: String,
    val updatedAt: Long = System.currentTimeMillis()
)
