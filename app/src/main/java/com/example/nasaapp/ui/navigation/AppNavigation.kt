package com.example.nasaapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nasaapp.ui.views.ApodView
import com.example.nasaapp.ui.views.HomeView

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME
    ) {
        composable(AppRoutes.HOME) { HomeView(navController) }
        composable(AppRoutes.APOD) { ApodView(navController) }
    }
}