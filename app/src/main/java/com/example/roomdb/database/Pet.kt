package com.example.roomdb.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pet (
    @PrimaryKey(autoGenerate = true) val petId: Long = 0,
    val name: String,
    val userOwnerId: Long
)