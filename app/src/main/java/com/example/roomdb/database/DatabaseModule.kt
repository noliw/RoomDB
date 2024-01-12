package com.example.roomdb.database

import android.content.Context
import androidx.room.Room
import com.example.roomdb.database.UserDatabase
import com.example.roomdb.database.UserDao
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
    fun providedDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "my_database").build()


    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao  = userDatabase.userDao

    @Provides
    @Singleton
    fun providePetDao(userDatabase: UserDatabase): PetDao = userDatabase.petDao

}