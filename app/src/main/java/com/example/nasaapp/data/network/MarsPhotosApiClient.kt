package com.example.nasaapp.data.network

import com.example.nasaapp.BuildConfig
import com.example.nasaapp.data.models.MarsPhotoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarsPhotosApiClient {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun fetchMarsPhotos(
        @Query("earth_date") earthDate: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): MarsPhotosResponse
}