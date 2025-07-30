package com.example.nasaapp.data.models

import com.google.gson.annotations.SerializedName

data class MarsRoverCameraModel(
    @SerializedName("full_name") val fullName: String
)