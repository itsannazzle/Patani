package com.nextint.patani.core.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserLogin (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val email : String
    )