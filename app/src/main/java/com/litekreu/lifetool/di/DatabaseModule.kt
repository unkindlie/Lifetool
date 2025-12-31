package com.litekreu.lifetool.di

import android.content.Context
import androidx.room.Room
import com.litekreu.lifetool.database.LifetoolDatabase
import com.litekreu.lifetool.features.note.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LifetoolDatabase {
        return Room.databaseBuilder(
            context,
            LifetoolDatabase::class.java,
            "lifetool_db"
        )
            .build()
    }

    @Provides
    fun provideNoteDao(db: LifetoolDatabase): NoteDao = db.noteDao
}