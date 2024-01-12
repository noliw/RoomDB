package com.example.roomdb.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant


//This is the model

@Entity
data class User(
    // We need a unique property to identify each instance
    // here we want userId to be that key
    @PrimaryKey(autoGenerate = true) val userId: Long = 0,
    val username: String,
    val email: String,
    val phoneNumber: String,
    // Instant represents any point of time in the past present or future
    val createdAt: Instant,
    @Embedded(prefix = "address_")
    val address: Address,
)

@Entity
data class Address(
    // We need a unique property to identify each instance
    // here we want userId to be that key
    val addressId: Long,
    @ColumnInfo(name = "city_name")
    val city: String,
)