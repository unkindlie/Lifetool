package com.litekreu.lifetool.features.note

import androidx.room.Dao
import androidx.room.Query
import com.litekreu.lifetool.features.note.classes.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): Flow<List<NoteEntity>>
}