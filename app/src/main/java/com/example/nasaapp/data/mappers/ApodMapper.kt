package com.example.nasaapp.data.mappers

import com.example.nasaapp.data.models.ApodModel
import com.example.nasaapp.domain.entities.ApodEntity

fun ApodModel.toEntity(): ApodEntity = ApodEntity(
    title = title,
    explanation = explanation,
    imageUrl = url,
    date = date,
)