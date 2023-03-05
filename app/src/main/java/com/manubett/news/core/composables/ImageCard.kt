package com.manubett.news.core.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.manubett.news.R
import com.manubett.news.feature_posts.domain.model.NewsItem
import com.manubett.news.ui.theme.NewsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCard2(
    modifier: Modifier = Modifier,
    news: NewsItem
) {
    Column(modifier = Modifier.fillMaxSize()){
//        Card(
//            modifier = modifier
//                .fillMaxWidth(),
//            shape = MaterialTheme.shapes.large,
//        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(R.drawable.post)
//                    .crossfade(durationMillis = 250)
//                    .placeholder(R.drawable.placeholder)
//                    .error(R.drawable.ic_broken_image)
//                    .fallback(R.drawable.placeholder)
//                    .build(),
//                contentDescription = "contentDescription",
//                contentScale = ContentScale.Crop,
//            )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.background
                                ),
                                startY = 300f
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                ) {
                    ProfileImage(news=news){

                    }
                    Text(text = "Bett Manu")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(
                            MaterialTheme.colorScheme.background.copy(0.24f),
                            shape = MaterialTheme.shapes.medium
                        )
                        .align(Alignment.BottomEnd)
                        .wrapContentHeight()
                        .wrapContentWidth(),
                ) {
                    Text(text = "Edit profile")
                }
            }
//        }
    }
}

