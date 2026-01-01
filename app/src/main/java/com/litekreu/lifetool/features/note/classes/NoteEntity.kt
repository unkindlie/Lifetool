package com.litekreu.lifetool.features.note.classes

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Entity(tableName = "notes")
@Parcelize
data class NoteEntity(
    @PrimaryKey val id: String,
    val title: String,
    val text: String,
    @ColumnInfo(name = "created_at") val createdAt: LocalDateTime
) : Parcelable

fun NoteEntity.toDomain() = Note(id, title, text, createdAt)