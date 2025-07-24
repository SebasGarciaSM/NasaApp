package com.example.nasaapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nasaapp.R
import com.example.nasaapp.ui.core.HomeCard
import com.example.nasaapp.ui.models.HomeCardConfig
import com.example.nasaapp.ui.navigation.AppRoutes
import com.example.nasaapp.ui.theme.AppColors

@Composable
fun HomeView(navController: NavHostController) {
    HomeViewContent(
        navController = navController,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViewContent(navController: NavHostController) {
    val cards: List<HomeCardConfig> = listOf(
        HomeCardConfig(
            icon = Icons.Filled.Photo,
            title = stringResource(R.string.apod_astronomy_picture_of_the_day),
            lightColor = AppColors.apodLight,
            darkColor = AppColors.apodDark,
            onTap = { navController.navigate(AppRoutes.APOD) }
        ),
        HomeCardConfig(
            icon = Icons.Filled.Landscape,
            title = stringResource(R.string.mars_rover_photos),
            lightColor = AppColors.marsLight,
            darkColor = AppColors.marsDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.BlurOn,
            title = stringResource(R.string.neows_asteroids),
            lightColor = AppColors.asteroidsLight,
            darkColor = AppColors.asteroidsDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.Public,
            title = stringResource(R.string.epic_earth_imagery),
            lightColor = AppColors.epicLight,
            darkColor = AppColors.epicDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.WbSunny,
            title = stringResource(R.string.donki_solar_activity),
            lightColor = AppColors.donkiLight,
            darkColor = AppColors.donkiDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.Lightbulb,
            title = stringResource(R.string.techtransfer),
            lightColor = AppColors.techLight,
            darkColor = AppColors.techDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.VideoLibrary,
            title = stringResource(R.string.image_and_video_library),
            lightColor = AppColors.mediaLibLight,
            darkColor = AppColors.mediaLibDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.TravelExplore,
            title = stringResource(R.string.exoplanet_archive),
            lightColor = AppColors.exoplanetLight,
            darkColor = AppColors.exoplanetDark,
            onTap = {}
        ),
        HomeCardConfig(
            icon = Icons.Filled.Map,
            title = stringResource(R.string.earth_assets),
            lightColor = AppColors.earthAssetsLight,
            darkColor = AppColors.earthAssetsDark,
            onTap = {}
        ),
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(R.string.nasa_app)) }) }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(cards) { item ->
                HomeCard(
                    cardConfig = item
                )
            }
        }
    }
}