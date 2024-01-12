package com.example.roomdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.roomdb.database.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Upsert
    // insert into User values(1, 'test', "test@gmail.com", "123")
    suspend fun insertUser(user: User): Long


    // to read from db
    // Select all the details from user table (User) where user ID is whatever we are passing to the function
    @Query("SELECT * FROM User WHERE userId= :userId")
    suspend fun getUser(userId: Long): User

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM User")
    fun getAllObsUsers(): Flow<List<User>>


}