package com.litekreu.lifetool.di

import android.app.Application
import androidx.room.Room
import com.litekreu.lifetool.data.LifetoolDatabase
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
}