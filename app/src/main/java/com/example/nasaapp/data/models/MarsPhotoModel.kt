package com.example.nasaapp.data.models

import com.google.gson.annotations.SerializedName

data class MarsPhotoModel(
    @SerializedName("id") val id: String,
    @SerializedName("img_src") val imgSrc: String,
    @SerializedName("earth_date") val earthDate: String,
    @SerializedName("camera") val camera: MarsRoverCameraModel,
    @SerializedName("rover") val rover: MarsRoverModel,
)