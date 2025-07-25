package com.example.nasaapp.ui.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nasaapp.R

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val preLoaderLottieComposition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                R.raw.loading_rocket
            )
        )

        val preLoaderProgress by animateLottieCompositionAsState(
            preLoaderLottieComposition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true,
        )

        LottieAnimation(
            composition = preLoaderLottieComposition,
            progress = { preLoaderProgress },
            modifier = Modifier.size(200.dp)
        )
    }
}