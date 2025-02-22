package com.memtionsandroid.memotions.data.remote.response.auth

import com.google.gson.annotations.SerializedName

data class AuthResponse(

	@field:SerializedName("data")
	val data: AuthData,

	@field:SerializedName("errors")
	val errors: Any?,

	@field:SerializedName("status")
	val status: String
)

data class AuthData(

	@field:SerializedName("user")
	val user: User,

	@field:SerializedName("token")
	val token: String
)

data class User(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("email")
	val email: String
)
