package com.example.nasaapp.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nasaapp.R
import java.time.LocalDateTime

@Composable
fun EpicView(navController: NavHostController) {
    EpicView(modifier = Modifier, navController = navController)
}

@Composable
private fun EpicView(modifier: Modifier, navController: NavHostController) {
    EpicViewContent(
        onBackPressed = { navController.popBackStack() },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EpicViewContent(
    onBackPressed: () -> Unit,
) {
    val items = listOf(1, 2, 3, 4, 5)

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.epic_earth_imagery)) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "")
                    }
                }
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier.padding(vertical = 12.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    onClick = {},
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(R.drawable.apod),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            LocalDateTime.now().toString(),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                        Text("Here will be the description")
                        Text(stringResource(R.string.latitude, ""))
                        Text(stringResource(R.string.longitude, ""))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun EpicViewPreview() {
    EpicViewContent(
        onBackPressed = { }
    )
}