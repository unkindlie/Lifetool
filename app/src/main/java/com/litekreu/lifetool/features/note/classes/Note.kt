package com.litekreu.lifetool.features.note.classes

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@SuppressLint("NewApi")
data class Note(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val text: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    val createdDateFormatted: String
        get() = createdAt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}

fun Note.toEntity() = NoteEntity(id, title, text, createdAt)
