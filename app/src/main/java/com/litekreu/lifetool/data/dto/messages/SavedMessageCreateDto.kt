package com.litekreu.lifetool.data.dto.messages

data class SavedMessageCreateDto(
    val text: String,
    val createdAt: Long = System.currentTimeMillis()
)
