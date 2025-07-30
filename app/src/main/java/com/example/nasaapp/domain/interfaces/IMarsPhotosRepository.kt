package com.example.nasaapp.domain.interfaces

import com.example.nasaapp.domain.entities.MarsPhotoEntity
import com.example.nasaapp.domain.models.DomainState
import java.time.LocalDate

interface IMarsPhotosRepository {
    suspend fun  fetchMarsPhotos(earthDate: String): DomainState<List<MarsPhotoEntity>>
}