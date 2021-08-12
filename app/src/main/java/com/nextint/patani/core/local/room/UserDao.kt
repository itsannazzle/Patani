package com.nextint.patani.core.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import com.nextint.patani.core.local.entity.UserLogin

@Dao
interface UserDao {
    @Insert
    fun userLogin(email: UserLogin)
}