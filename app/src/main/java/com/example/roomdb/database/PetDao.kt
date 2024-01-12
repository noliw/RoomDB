package com.example.roomdb.database

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface PetDao {
    @Upsert
    suspend fun upsertPet(pet: Pet)
}