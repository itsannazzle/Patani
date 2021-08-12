package com.nextint.patani.core.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nextint.patani.core.local.entity.UserRegisterEntity
import com.nextint.patani.core.remote.response.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RemoteDataSource {
    private val handler = Handler(Looper.getMainLooper())
    companion object{
        @Volatile
        private var instance : RemoteDataSource? = null
        fun getInstance() : RemoteDataSource =
            instance?: synchronized(this){
                instance?: RemoteDataSource().apply { instance = this }
            }
    }

    fun postLogin(email: String, password: String) : LiveData<String>{
        val dataResult = MutableLiveData<String>()
        Config.retrofitRequest().userLogin(email, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    handler.post {
                        dataResult.value = response.body()?.username
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Timber.i(t)
               // dataResult.value = t.message
            }
        })
        return dataResult
    }

    fun postRegister(registerEntity : UserRegisterEntity) : LiveData<Boolean>{
        var registerStatus = MutableLiveData<Boolean>()
        with(registerEntity){
            Config.retrofitRequest().userResgister(email,nomorTelpon,password).enqueue(object :
                Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful.and(response.code() == 200)){
                        handler.post {
                            registerStatus.value = true
                        }
                    } else {
                        handler.post {
                            registerStatus.value = false
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Timber.i(t)
                    handler.post {
                        registerStatus.value = false
                    }
                }
            })
        }
        return registerStatus
    }
}