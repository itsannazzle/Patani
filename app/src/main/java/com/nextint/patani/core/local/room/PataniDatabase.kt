package com.nextint.patani.core.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nextint.patani.core.local.entity.UserLogin

@Database(entities = [UserLogin::class],version = 1,exportSchema = false)
abstract class PataniDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao
    companion object{
        @Volatile
        private var instance : PataniDatabase? = null
        fun getInstance(context: Context) : PataniDatabase =
            instance ?: synchronized(this) {
                instance?: Room.databaseBuilder(
                    context.applicationContext,
                    PataniDatabase::class.java,
                    "PataniDatabase")
                    .build()
            }.apply { instance = this }
    }
}