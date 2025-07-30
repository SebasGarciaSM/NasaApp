package com.example.nasaapp.data.mappers

import com.example.nasaapp.data.models.MarsPhotoModel
import com.example.nasaapp.domain.entities.MarsPhotoEntity

fun MarsPhotoModel.toEntity(): MarsPhotoEntity = MarsPhotoEntity(
    id = id,
    imgSrc = imgSrc,
    earthDate = earthDate,
    cameraName = camera.fullName,
    roverName = rover.name,
)