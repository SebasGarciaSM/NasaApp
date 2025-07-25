package com.example.nasaapp.data.repositories

import coil.network.HttpException
import com.example.nasaapp.data.mappers.toEntity
import com.example.nasaapp.data.network.ApodApiClient
import com.example.nasaapp.domain.entities.ApodEntity
import com.example.nasaapp.domain.interfaces.IApodRepository
import com.example.nasaapp.domain.models.DomainState
import okio.IOException
import javax.inject.Inject

class ApodRepository @Inject constructor(
    private val api: ApodApiClient,
) : IApodRepository {
    override suspend fun fetchApod(): DomainState<ApodEntity> {
        return try {
            val response = api.fetchApod()
            if (response.isSuccessful) {
                val apod = response.body()
                if (apod != null) {
                    DomainState.Success(
                        data = apod.toEntity()
                    )
                } else {
                    DomainState.Error(response.message())
                }
            } else {
                DomainState.Error(response.message())
            }
        } catch (e: IOException) {
            DomainState.Error(message = "Network error: ${e.message}")
        } catch (e: HttpException) {
            DomainState.Error(message = "HTTP error: ${e.message}")
        } catch (e: Exception) {
            DomainState.Error(message = "Unexected error: ${e.message}")
        }
    }
}