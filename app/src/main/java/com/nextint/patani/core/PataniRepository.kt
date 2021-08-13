package com.nextint.patani.core

import androidx.lifecycle.LiveData
import com.nextint.patani.core.local.LocalDataSource
import com.nextint.patani.core.local.entity.UserRegisterEntity
import com.nextint.patani.core.remote.RemoteDataSource
import com.nextint.patani.core.remote.response.LoginResponse
import java.lang.Exception
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class PataniRepository private constructor(private val remoteDataSource: RemoteDataSource,
                                           private val localDataSource: LocalDataSource,
                                           private val executorService: ExecutorService) {
    companion object{
        private var instance : PataniRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource,
                        localDataSource: LocalDataSource) : PataniRepository =
            instance ?: synchronized(this){
                instance ?: PataniRepository(remoteDataSource, localDataSource, Executors.newSingleThreadExecutor()).apply { instance = this }
            }
    }

    fun loginValidation(email : String, password : String) : LiveData<LoginResponse> {
        return remoteDataSource.postLogin(email, password)
    }

    fun postRegistration(registerData : UserRegisterEntity) : LiveData<Boolean>{
        return remoteDataSource.postRegister(registerData)
    }
}