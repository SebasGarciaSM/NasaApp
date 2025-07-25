package com.example.nasaapp.di

import androidx.compose.runtime.internal.DecoyImplementation
import com.example.nasaapp.data.repositories.ApodRepository
import com.example.nasaapp.domain.interfaces.IApodRepository
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

}