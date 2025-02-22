package com.memtionsandroid.memotions.data.remote.response.journals

import com.google.gson.annotations.SerializedName

data class JournalResponse(

	@field:SerializedName("data")
	val data: JournalData,

	@field:SerializedName("errors")
	val errors: Any?,

	@field:SerializedName("status")
	val status: String
)

data class JournalData(

	@field:SerializedName("feedback")
	val feedback: String?,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("emotionAnalysis")
	val emotionAnalysis: List<EmotionAnalysisItem>?,

	@field:SerializedName("datetime")
	val datetime: String,

	@field:SerializedName("deleted")
	val deleted: Boolean,

	@field:SerializedName("starred")
	val starred: Boolean,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("tags")
	val tags: List<String>?
)
