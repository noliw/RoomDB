package com.example.roomdb

import android.content.Context
import androidx.room.Room
import com.example.w4storage.day2Room.database.UserDatabase
import com.example.w4storage.day2Room.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providedDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, "my_database").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao
    }
}