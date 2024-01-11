package com.example.roomdb.database

import com.example.roomdb.database.User
import com.example.roomdb.database.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun insertUser(user: User){
        userDao.insertUser(user = user)
    }
    suspend fun getUser(userId: Long): User {
        return userDao.getUser(userId = userId)
    }
}