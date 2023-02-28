package com.core.remote.response.dto

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("text")
    val text: String?,
    @SerializedName("code")
    val code: Int?,
    @SerializedName("icon")
    val icon: String?
)