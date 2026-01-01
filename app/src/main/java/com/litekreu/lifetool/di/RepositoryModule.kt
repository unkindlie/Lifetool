package com.litekreu.lifetool.di

import com.litekreu.lifetool.features.note.NoteRepository
import com.litekreu.lifetool.features.note.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNotesRepository(
        impl: NoteRepositoryImpl
    ): NoteRepository
}