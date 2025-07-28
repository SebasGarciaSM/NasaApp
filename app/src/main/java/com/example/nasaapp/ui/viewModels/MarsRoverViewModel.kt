package com.example.nasaapp.ui.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import androidx.compose.runtime.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MarsRoverViewModel @Inject constructor() : ViewModel() {

    private val _selectedDate = mutableStateOf<LocalDate?>(null)
    val selectedDate: State<LocalDate?> = _selectedDate

    private val _showDatePicker = mutableStateOf(false)
    val showDatePicker: State<Boolean> = _showDatePicker

    fun onOpenDatePicker() {
        _showDatePicker.value = true
    }

    fun onDismissDatePicker() {
        _showDatePicker.value = false
    }

    fun onDatePicked(date: LocalDate?) {
        _selectedDate.value = date
        _showDatePicker.value = false
        println(date)
    }

}