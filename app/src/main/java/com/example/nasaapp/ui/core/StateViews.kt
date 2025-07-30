package com.example.nasaapp.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nasaapp.R
import com.example.nasaapp.ui.theme.AppColors

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

@Composable
fun ErrorView(modifier: Modifier = Modifier, errorMessage: String, onRetry: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val preLoaderLottieComposition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                R.raw.space_cat,
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
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AppColors.white)
                .padding(24.dp)
        ) {
            Column {
                Text(errorMessage)
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onRetry,
                ) {
                    Text(
                        stringResource(R.string.retry),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun NoDataFoundLottie(modifier: Modifier = Modifier, message: String) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        val preLoaderLottieComposition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                R.raw.space_boy_developer,
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
            modifier = Modifier.size(200.dp),
        )
        Text(
            stringResource(R.string.no_data_found), style = TextStyle(
                fontSize = 18.sp
            )
        )
        Text(message)
    }
}