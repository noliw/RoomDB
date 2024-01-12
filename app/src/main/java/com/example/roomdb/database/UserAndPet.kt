package com.example.roomdb.database

import androidx.room.Embedded
import androidx.room.Relation

// Intermediate representation to retrieve user and pet
data class UserAndPet(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val pet: Pet
)
