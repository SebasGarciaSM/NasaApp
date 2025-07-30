package com.example.nasaapp.di

import com.example.nasaapp.BuildConfig
import com.example.nasaapp.data.network.ApodApiClient
import com.example.nasaapp.data.network.MarsPhotosApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApodApiClient(retrofit: Retrofit): ApodApiClient {
        return retrofit.create(ApodApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideMarsPhotosApiClient(retrofit: Retrofit): MarsPhotosApiClient {
        return retrofit.create(MarsPhotosApiClient::class.java)
    }

}