package com.example.nasaapp.domain.interfaces

import com.example.nasaapp.domain.entities.ApodEntity
import com.example.nasaapp.domain.models.DomainState

interface IApodRepository {
    suspend fun fetchApod(): DomainState<ApodEntity>
}