package com.example.nasaapp.domain.models

sealed class DomainState<out T> {
    data object Initial : DomainState<Nothing>()
    data class Success<T>(val data: T) : DomainState<T>()
    data class Error(val message: String) : DomainState<Nothing>()
    data object Loading : DomainState<Nothing>()
}