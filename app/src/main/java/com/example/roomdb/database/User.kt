package com.example.roomdb.database

import androidx.room.Entity
import androidx.room.PrimaryKey


//This is the model

@Entity
data class User(
    // We need a unique property to identify each instance
    // here we want userId to be that key
    @PrimaryKey(autoGenerate = true) val userId: Long,
    val username: String,
    val email: String,
    val phoneNumber: String
)