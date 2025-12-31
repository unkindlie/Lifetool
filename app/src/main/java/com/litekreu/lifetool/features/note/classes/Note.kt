package com.litekreu.lifetool.features.note.classes

import java.time.LocalDateTime

data class Note (
    val id: String,
    val title: String,
    val text: String,
    val createdAt: LocalDateTime
)

fun Note.toEntity() = NoteEntity(id, title, text, createdAt)
