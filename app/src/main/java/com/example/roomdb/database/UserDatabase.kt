package com.example.roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [User::class]
)
// it is abstract because we don't want to implement those methods
abstract class UserDatabase: RoomDatabase() {
    // Dao reference
    abstract val userDao: UserDao
}