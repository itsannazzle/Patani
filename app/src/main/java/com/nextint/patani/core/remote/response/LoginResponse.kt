package com.nextint.patani.core.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class LoginResponse(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("phone_number")
	val phoneNumber: String,

	@field:SerializedName("id_user")
	val idUser: Int,

	@field:SerializedName("email")
	val email: String
)
