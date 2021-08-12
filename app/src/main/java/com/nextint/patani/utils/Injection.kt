package com.nextint.patani.utils

import android.content.Context
import com.nextint.patani.core.PataniRepository
import com.nextint.patani.core.local.LocalDataSource
import com.nextint.patani.core.local.room.PataniDatabase
import com.nextint.patani.core.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context) : PataniRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        val db = PataniDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(db.userDao())
        return PataniRepository.getInstance(remoteDataSource, localDataSource)
    }

}