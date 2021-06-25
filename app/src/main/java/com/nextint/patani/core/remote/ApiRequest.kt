package com.nextint.patani.core.remote

import retrofit2.http.Field
import retrofit2.http.POST
import java.util.concurrent.Flow

interface ApiRequest {

    @POST("user/register")
    fun userResgister(
        @Field("email") email : String,
        @Field("phoneNumber") phoneNumber : String,
        @Field("password") password : String,
    ) : Flow

    @POST("user/login")
    fun userLogin(
        @Field("email") email : String,
        @Field("password") password: String,
    ) : Flow

}