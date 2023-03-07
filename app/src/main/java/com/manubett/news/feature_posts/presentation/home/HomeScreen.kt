package com.manubett.news.feature_posts.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.manubett.news.R
import com.manubett.news.core.composables.ProfileImage
import com.manubett.news.feature_posts.domain.model.NewsDetails
import com.manubett.news.feature_posts.domain.model.NewsItem
import com.manubett.news.navigation.BottomNavItem
import com.manubett.news.navigation.BottomNavMenu
import com.manubett.news.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ViewHeadline,
                            contentDescription = "Headlines"
                        )
                    }
                },
                title = {
                    Text(text = "News of the day")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.NotificationsActive,
                            contentDescription = "Notification"
                        )
                    }
                },
                backgroundColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
                modifier = Modifier
                    .wrapContentHeight()
                    .clip(CircleShape),
                contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            )

        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(48.dp),
                containerColor = if (isSystemInDarkTheme()) Color.Black.copy(.24f) else Color.White.copy(
                    .24f
                ),
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.HOME, navController)
            }
        }
    ) { paddingValues ->
        val viewModel: HomeViewModel = hiltViewModel()
        val state = viewModel.newsListState.value
        Box {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = paddingValues.calculateBottomPadding(),
                        top = paddingValues.calculateTopPadding()
                    )
            ) {
                items(state.news) { news ->

                   ImageCard(
                       news = news,
                       viewModel = viewModel,
                       navController = navController
                   )
                }

            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
        }
    }
}

@Composable
fun ImageCard(
    news: NewsItem,
    viewModel: HomeViewModel,
    navController: NavController
) {
    val clicked by remember {
        mutableStateOf(true)
    }
    Column() {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier.width(48.dp)
                    ) {
                        news.authorsImage?.forEach { authorsImage ->
                            ProfileImage(image = authorsImage, modifier = Modifier.size(48.dp)) {

                            }
                        }

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    news.author?.forEach { author ->
                        Text(
                            text = author.ifEmpty { "Guardians" },
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "~ ${news.time}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "more",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        )
                    }
                }
            }
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(news.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.placeholder),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    val newsDetail = NewsDetails(
                        tagId = news.tagId,
                        resultId = news.resultId,
                        twitterHandle = news.twitterHandle,
                        image = news.image,
                        title = news.title, headline = news.headline,
                        time = news.time,
                        author = news.author,
                        ratings = news.ratings,
                        sourcePublication = news.sourcePublication,
                        authorsImage = news.authorsImage,
                        sectionName = news.sectionName,
                        body = news.body,
                        bodyText = news.bodyText,
                        trailText = news.trailText,
                        bio = news.bio,
                        productionOffice = news.productionOffice,
                        lastModified = news.lastModified,
                        fullNames = news.fullNames, id = news.id
                    )
                    viewModel.addDetails(newsDetail)
                    navController.navigate(Screens.DetailScreen.route + "?newsId=${news.id}") {
                        popUpTo(Screens.DetailScreen.route + "?newsId=${news.id}") {
                            inclusive = true
                        }
                    }
                }
                .clip(MaterialTheme.shapes.large),
            fallback = painterResource(id = R.drawable.placeholder),
        )

        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = if (clicked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "favourite"
                        )
                    }
                    Text(text = "128")
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Chat, contentDescription = "Chats")
                    }
                    Text(text = "80")
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "share")
                    }
                    Text(text = "1.2k")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(imageVector = Icons.Default.StarRate, contentDescription = "Rating")
                    news.ratings?.let { rating ->
                        Text(
                            text = rating,
                            color = if (isSystemInDarkTheme()) Color.White else Color.Black
                        )
                    }
                }
            }
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            news.title?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.titleSmall,
                    fontFamily = FontFamily.Serif,
                    color = Color.Cyan,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Divider()
    Spacer(modifier = Modifier.height(6.dp))
}

