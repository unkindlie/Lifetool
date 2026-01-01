package com.litekreu.lifetool.features.note

import com.litekreu.lifetool.features.note.classes.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun deleteNoteById(id: String)
}