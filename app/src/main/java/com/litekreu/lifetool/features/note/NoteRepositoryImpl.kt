package com.litekreu.lifetool.features.note

import com.litekreu.lifetool.features.note.classes.Note
import com.litekreu.lifetool.features.note.classes.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes().map { note -> note.map { it.toDomain() } }
    }
}