package com.litekreu.lifetool.di

import android.app.Application
import androidx.room.Room
import com.litekreu.lifetool.data.LifetoolDatabase
import com.litekreu.lifetool.data.dao.TaskDao
import com.litekreu.lifetool.data.repo.TaskRepository
import com.litekreu.lifetool.data.repo.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesLifetoolDatabase(app: Application): LifetoolDatabase {
        return Room.databaseBuilder(
            app,
            LifetoolDatabase::class.java,
            "lifetool_db"
        )
            .build()
    }

    @Provides
    fun providesTaskDao(
        database: LifetoolDatabase
    ): TaskDao {
        return database.taskDao
    }

    @Provides
    @Singleton
    fun providesTaskRepo(
        taskDao: TaskDao
    ): TaskRepository {
        return TaskRepositoryImpl(taskDao)
    }
}