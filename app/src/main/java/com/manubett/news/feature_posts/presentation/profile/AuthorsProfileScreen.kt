package com.manubett.news.feature_posts.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.manubett.news.R
import com.manubett.news.core.composables.ProfileImage
import com.manubett.news.feature_posts.domain.model.NewsItem
import com.manubett.news.feature_posts.presentation.home.HomeViewModel
import com.manubett.news.ui.theme.lightBlue


@Composable
fun AuthorsProfileScreen(
    viewModel: HomeViewModel
//    navController: NavController
) {
    val link1 =
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/XXXTENTACION_mugshot_12_28_2016.jpg/800px-XXXTENTACION_mugshot_12_28_2016.jpg"
    val state = viewModel.newsListState.value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)

                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.post)
                    .crossfade(durationMillis = 250)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.ic_broken_image)
                    .fallback(R.drawable.placeholder)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                            ),
                            startY = 210f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp)
            ) {

                ProfileImage(image = link1) {

                }
            }
            Box(modifier = Modifier.clip(RoundedCornerShape(100))) {
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = if (isSystemInDarkTheme())
                            Color.Black.copy(.5f) else
                            Color.White.copy(.5f),
                        contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                    ),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clip(CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            }
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.BottomEnd)
                    .padding(end = 10.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .wrapContentHeight(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme())
                            Color.White.copy(.24f) else
                            Color.Black.copy(.24f),
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Edit profile",
                        color = if (isSystemInDarkTheme()) Color.Black else Color.White,
                    )
                }
            }
        }
    }

    @Composable
    fun Profile(
        onClicked: () -> Unit,
        news: NewsItem
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            val link1 =
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/XXXTENTACION_mugshot_12_28_2016.jpg/800px-XXXTENTACION_mugshot_12_28_2016.jpg"
            ProfileImage(image = link1) {

            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Manu Bett",
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "@manubett",
                color = lightBlue,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
            )
        }
    }
}

