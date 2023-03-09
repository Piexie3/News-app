package com.manubett.news.feature_posts.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.manubett.news.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                if (isSystemInDarkTheme())
                    Color.Black.copy(.24f) else
                    Color.White.copy(.24f)
            ),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data(R.drawable.shopping_gif)
            .crossfade(250)
            .build(),
            contentDescription = "splash Screen"
        )
    }
}
