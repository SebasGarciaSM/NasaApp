package com.example.nasaapp.data.repositories

import coil.network.HttpException
import com.example.nasaapp.data.mappers.toEntity
import com.example.nasaapp.data.network.MarsPhotosApiClient
import com.example.nasaapp.domain.entities.MarsPhotoEntity
import com.example.nasaapp.domain.interfaces.IMarsPhotosRepository
import com.example.nasaapp.domain.models.DomainState
import okio.IOException
import javax.inject.Inject

class MarsPhotosRepository @Inject constructor(
    private val api: MarsPhotosApiClient
) : IMarsPhotosRepository {
    override suspend fun fetchMarsPhotos(earthDate: String): DomainState<List<MarsPhotoEntity>> {
        return try {
            val response = api.fetchMarsPhotos(earthDate)
            val data = response.photos.map { it.toEntity() }
            DomainState.Success(data = data)
        } catch (e: IOException) {
            DomainState.Error(message = "Network error: ${e.message}")
        } catch (e: HttpException) {
            DomainState.Error(message = "HTTP error: ${e.message}")
        } catch (e: Exception) {
            DomainState.Error(message = "Unexpected error: ${e.message}")
        }
    }
}