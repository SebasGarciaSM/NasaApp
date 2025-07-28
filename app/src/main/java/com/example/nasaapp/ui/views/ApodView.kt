package com.example.nasaapp.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.nasaapp.R
import com.example.nasaapp.domain.entities.ApodEntity
import com.example.nasaapp.domain.models.DomainState
import com.example.nasaapp.ui.core.ErrorView
import com.example.nasaapp.ui.core.LoadingView
import com.example.nasaapp.ui.theme.AppColors
import com.example.nasaapp.ui.viewModels.ApodViewModel

@Composable
fun ApodView(navController: NavHostController, viewModel: ApodViewModel = hiltViewModel()) {
    val state by viewModel.apodState

    ApodViewContent(
        navController = navController,
        state = state,
        loadApod = { viewModel.loadApod() },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApodViewContent(
    navController: NavHostController,
    state: DomainState<ApodEntity>,
    loadApod: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.apod_astronomy_picture_of_the_day)) },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Back Icon Button")
                    }
                },
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (state) {
                is DomainState.Error -> {
                    ErrorView(modifier = Modifier.fillMaxSize(), errorMessage = state.message) {
                        loadApod()
                    }
                }

                DomainState.Initial -> {
                    LaunchedEffect(Unit) {
                        loadApod()
                    }
                }

                DomainState.Loading -> {
                    LoadingView(modifier = Modifier.fillMaxSize())
                }

                is DomainState.Success -> ApodSuccessView(
                    modifier = Modifier.fillMaxSize(),
                    data = state.data
                )
            }
        }
    }
}

@Composable
fun ApodSuccessView(modifier: Modifier = Modifier, data: ApodEntity) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Card(
            modifier = Modifier,
            elevation = CardDefaults.cardElevation(6.dp),
            onClick = {},
        ) {
            Box(contentAlignment = Alignment.BottomStart) {

                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    model = data.imageUrl,
                    contentDescription = "Astronomy Picture of the Day",
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    AppColors.transparent,
                                    AppColors.black60,
                                )
                            )
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        data.title,
                        style = MaterialTheme.typography.titleLarge.copy(color = AppColors.white),
                    )
                }
            }
        }
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    stringResource(R.string.overview),
                    style = MaterialTheme.typography.headlineMedium
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(AppColors.secondary)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(data.date)
                }
            }
            Text(data.explanation)
        }
    }

}