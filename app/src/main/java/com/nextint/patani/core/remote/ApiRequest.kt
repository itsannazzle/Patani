package com.nextint.patani.core.remote

import com.nextint.patani.core.remote.response.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.Flow

interface ApiRequest {

    @FormUrlEncoded
    @POST("user/register")
    fun userResgister(
        @Field("email") email : String,
        @Field("phoneNumber") phoneNumber : String,
        @Field("password") password : String,
    ) : Call<ResponseBody>

    @FormUrlEncoded
    @POST("user/login")
    fun userLogin(
        @Field("email") email : String,
        @Field("password") password: String,
    ) : Call<LoginResponse>

}