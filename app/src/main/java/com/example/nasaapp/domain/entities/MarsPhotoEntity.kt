package com.example.nasaapp.domain.entities

data class MarsPhotoEntity(
    val id: String,
    val imgSrc: String,
    val earthDate: String,
    val cameraName: String,
    val roverName: String,
)