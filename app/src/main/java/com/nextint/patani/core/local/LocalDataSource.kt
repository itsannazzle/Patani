package com.nextint.patani.core.local

import com.nextint.patani.core.local.entity.UserLogin
import com.nextint.patani.core.local.room.UserDao

class LocalDataSource private constructor(private val dao: UserDao){
    companion object{
        private var instance : LocalDataSource? = null
        fun getInstance(dao: UserDao) : LocalDataSource = instance ?: LocalDataSource(dao).apply { instance = this }
    }

    fun insertUserLogin(userLogin: UserLogin) = dao.userLogin(userLogin)
}