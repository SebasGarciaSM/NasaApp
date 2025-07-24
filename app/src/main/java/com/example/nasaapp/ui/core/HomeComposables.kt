package com.example.nasaapp.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.nasaapp.ui.models.HomeCardConfig

@Composable
fun HomeCard(
    cardConfig: HomeCardConfig
) {
    val isDark = isSystemInDarkTheme()
    val backgroundColor = if (isDark) cardConfig.darkColor else cardConfig.lightColor
    val foregroundColor = if (isDark) cardConfig.lightColor else cardConfig.darkColor

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = cardConfig.onTap
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(width = 50.dp, height = 50.dp)
                        .clip(shape = CircleShape)
                        .background(backgroundColor),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = cardConfig.icon,
                        contentDescription = "icon",
                        tint = foregroundColor,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 10.dp), text = cardConfig.title,
                )
            }
        }
    }
}