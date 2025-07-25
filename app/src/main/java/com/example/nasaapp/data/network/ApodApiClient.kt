package com.example.nasaapp.data.network

import com.example.nasaapp.BuildConfig
import com.example.nasaapp.data.models.ApodModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApiClient {

    @GET("planetary/apod")
    suspend fun fetchApod(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Response<ApodModel>

}