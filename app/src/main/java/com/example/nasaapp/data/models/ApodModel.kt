package com.example.nasaapp.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ApodModel(
    @SerializedName("title") val title: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("url") val url: String,
    @SerializedName("date") val date: String,
)
