package com.example.nasaapp.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.nasaapp.R
import com.example.nasaapp.domain.entities.MarsPhotoEntity
import com.example.nasaapp.domain.models.DomainState
import com.example.nasaapp.ui.core.DatePickerDialogComposable
import com.example.nasaapp.ui.core.ErrorView
import com.example.nasaapp.ui.core.LoadingView
import com.example.nasaapp.ui.core.MarsPhotoCard
import com.example.nasaapp.ui.theme.AppColors
import com.example.nasaapp.ui.viewModels.MarsRoverViewModel
import java.time.LocalDate

@Composable
fun MarsRoverView(
    navController: NavHostController,
    viewModel: MarsRoverViewModel = hiltViewModel()
) {
    MarsRoverView(
        modifier = Modifier,
        navController = navController,
        viewModel = viewModel,
    )
}

@Composable
private fun MarsRoverView(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MarsRoverViewModel,
) {

    val showDialog = viewModel.showDatePicker.value
    val state by viewModel.marsPhotosState

    MarsPhotosViewContent(
        state = state,
        showDialog = showDialog,
        onBackPressed = { navController.popBackStack() },
        onOpenDatePicker = { viewModel.onOpenDatePicker() },
        onDismissDialog = { viewModel.onDismissDatePicker() },
        onDatePicked = { viewModel.onDatePicked(it) },
        loadMarsPhotos = { viewModel.loadMarsPhotos() },
        selectedDate = viewModel.selectedDate.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MarsPhotosViewContent(
    state: DomainState<List<MarsPhotoEntity>>,
    showDialog: Boolean,
    onBackPressed: () -> Unit,
    onOpenDatePicker: () -> Unit,
    onDismissDialog: () -> Unit,
    onDatePicked: (LocalDate) -> Unit,
    loadMarsPhotos: () -> Unit,
    selectedDate: String
) {

    Scaffold(
        containerColor = AppColors.secondary,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.mars_rover_photos)) },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Back Icon Button")
                    }
                },
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            DatePickerDialogComposable(
                showDialog = showDialog,
                onDismiss = onDismissDialog,
                onDateSelected = onDatePicked
            )

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = true
                    )
                    .background(color = AppColors.white)
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = selectedDate,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(R.string.select_date)) },
                    trailingIcon = {
                        IconButton(onClick = onOpenDatePicker) {
                            Icon(
                                Icons.Default.CalendarToday,
                                contentDescription = stringResource(R.string.select_date)
                            )
                        }
                    }
                )
            }
            HorizontalDivider(
                modifier = Modifier,
                DividerDefaults.Thickness,
                DividerDefaults.color
            )
            when (state) {
                is DomainState.Error -> {
                    ErrorView(modifier = Modifier.fillMaxSize(), errorMessage = state.message) {
                        loadMarsPhotos()
                    }
                }

                DomainState.Initial -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(R.string.select_a_date))
                }

                DomainState.Loading -> {
                    LoadingView(modifier = Modifier.fillMaxSize())
                }

                is DomainState.Success -> {
                    LazyColumn(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        items(state.data) { item ->
                            MarsPhotoCard(
                                modifier = Modifier.padding(vertical = 12.dp),
                                marsPhoto = item
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MarsPhotosViewContentPreview() {
    MarsPhotosViewContent(
        showDialog = false,
        onBackPressed = { },
        onOpenDatePicker = { },
        onDismissDialog = { },
        onDatePicked = { },
        loadMarsPhotos = { },
        state = DomainState.Initial,
        selectedDate = ""
    )
}