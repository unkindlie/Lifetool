package com.litekreu.lifetool.features.note.classes

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity(tableName = "notes")
@Parcelize
data class NoteEntity (
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String,
    val text: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
): Parcelable {
    val createdDateFormatted : String
        get() = createdAt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}

fun NoteEntity.toDomain() = Note(id, title, text, createdAt)