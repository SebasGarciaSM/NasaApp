package com.example.nasaapp.di

import androidx.compose.runtime.internal.DecoyImplementation
import com.example.nasaapp.data.repositories.ApodRepository
import com.example.nasaapp.data.repositories.MarsPhotosRepository
import com.example.nasaapp.domain.interfaces.IApodRepository
import com.example.nasaapp.domain.interfaces.IMarsPhotosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindApodRepository(implementation: ApodRepository): IApodRepository

    @Binds
    @Singleton
    abstract fun bindMarsPhotosRepository(implementation: MarsPhotosRepository): IMarsPhotosRepository

}