package com.example.nasaapp.data.network

import com.example.nasaapp.data.models.MarsPhotoModel
import com.google.gson.annotations.SerializedName

data class MarsPhotosResponse(
    @SerializedName("photos") val photos: List<MarsPhotoModel>
)