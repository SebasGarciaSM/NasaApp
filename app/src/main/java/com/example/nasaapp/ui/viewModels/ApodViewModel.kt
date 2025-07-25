package com.example.nasaapp.ui.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.domain.entities.ApodEntity
import com.example.nasaapp.domain.interfaces.IApodRepository
import com.example.nasaapp.domain.models.DomainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApodViewModel @Inject constructor(private val repository: IApodRepository) : ViewModel() {

    private val _apodState = mutableStateOf<DomainState<ApodEntity>>(DomainState.Initial)

    val apodState: State<DomainState<ApodEntity>>
        get() = _apodState

    fun loadApod() {
        viewModelScope.launch {
            _apodState.value = DomainState.Loading
            val result = repository.fetchApod()
            _apodState.value = result
        }
    }

}