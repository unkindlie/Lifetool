package com.litekreu.lifetool.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.litekreu.lifetool.common.converters.DateConverter
import com.litekreu.lifetool.features.note.NoteDao
import com.litekreu.lifetool.features.note.classes.NoteEntity

@Database(
    version = 1,
    entities = [
        NoteEntity::class,
    ],
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class LifetoolDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}