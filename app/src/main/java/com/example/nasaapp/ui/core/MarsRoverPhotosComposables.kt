package com.example.nasaapp.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nasaapp.R
import com.example.nasaapp.domain.entities.MarsPhotoEntity

@Composable
fun MarsPhotoCard(modifier: Modifier = Modifier, marsPhoto: MarsPhotoEntity) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = {},
    ) {
        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = marsPhoto.imgSrc,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Camera: ${marsPhoto.cameraName}")
                Text("Date: ${marsPhoto.earthDate}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarsPhotoCardPreview() {
    MarsPhotoCard(
        marsPhoto = MarsPhotoEntity(
            id = "",
            imgSrc = "",
            earthDate = "",
            cameraName = "",
            roverName = ""
        )
    )
}