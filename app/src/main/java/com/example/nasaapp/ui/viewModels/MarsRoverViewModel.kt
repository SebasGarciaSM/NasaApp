package com.example.nasaapp.ui.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.nasaapp.domain.entities.MarsPhotoEntity
import com.example.nasaapp.domain.interfaces.IMarsPhotosRepository
import com.example.nasaapp.domain.models.DomainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverViewModel @Inject constructor(
    private val repository: IMarsPhotosRepository
) : ViewModel() {

    private val _marsPhotosState =
        mutableStateOf<DomainState<List<MarsPhotoEntity>>>(DomainState.Initial)
    val marsPhotosState: State<DomainState<List<MarsPhotoEntity>>>
        get() = _marsPhotosState

    private val _selectedDate = mutableStateOf<String>("")
    val selectedDate: State<String> = _selectedDate

    private val _showDatePicker = mutableStateOf(false)
    val showDatePicker: State<Boolean> = _showDatePicker

    fun onOpenDatePicker() {
        _showDatePicker.value = true
    }

    fun onDismissDatePicker() {
        _showDatePicker.value = false
    }

    fun onDatePicked(date: LocalDate?) {
        _selectedDate.value = date.toString()
        _showDatePicker.value = false
        println(date)
        loadMarsPhotos()
    }

    fun loadMarsPhotos() {
        viewModelScope.launch {
            _marsPhotosState.value = DomainState.Loading
            val result = repository.fetchMarsPhotos(selectedDate.value)
            _marsPhotosState.value = result
        }
    }

}