package com.example.nasaapp.ui.models
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class HomeCardConfig(
    val icon: ImageVector,
    val title: String,
    val lightColor: Color,
    val darkColor: Color,
    val onTap: () -> Unit,
    )