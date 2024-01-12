package com.example.roomdb.database

import androidx.room.Dao
import com.example.roomdb.database.User
import com.example.roomdb.database.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val petDao: PetDao

) {
    suspend fun insertUser(user: User): Long {
       return userDao.insertUser(user = user)
    }
    suspend fun getUser(userId: Long): User {
        return userDao.getUser(userId = userId)
    }
    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }
    fun getAllObsUsers(): Flow<List<User>> {
        return userDao.getAllObsUsers()
    }

    suspend fun insertPet(pet: Pet){
        petDao.upsertPet(pet = pet)
    }
}