package com.manubett.news.feature_posts.presentation.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.manubett.news.R
import com.manubett.news.core.composables.SearchBar
import com.manubett.news.feature_posts.domain.model.NewsItem
import com.manubett.news.navigation.BottomNavItem
import com.manubett.news.navigation.BottomNavMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column() {
                        Text(
                            text = "Discover",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "Any type of news and article",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Sort,
                            contentDescription = "Filter"
                        )
                    }
                },
                backgroundColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(48.dp),
                containerColor = if (isSystemInDarkTheme())
                    Color.Black.copy(.24f) else
                    Color.White.copy(
                        .24f
                    ),
            ) {
                BottomNavMenu(selectedItem = BottomNavItem.SEARCH, navController)
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { PaddingValues ->
        val searchState = searchViewModel.searchListState.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = PaddingValues.calculateBottomPadding(),
                    top = PaddingValues.calculateTopPadding()
                ),
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .fillMaxWidth()
            ) {
                SearchBar(
                    onSearchParamChange = {

                    },
                    onSearchClick = {

                    })
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                items(searchState.news){ news->
                    SearchedItem(news = news)
                }
            }
        }
    }
}


@Composable
fun SearchedItem(
    news: NewsItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable {


            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(news.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = news.title,
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .size(height = 94.dp, width = 120.dp),
            contentScale = ContentScale.FillBounds,
            fallback = painterResource(id = R.drawable.placeholder)
        )

        Column(
            modifier = Modifier
                .padding(start = 7.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {

            //news headline
            news.headline?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(start = 4.dp, top = 1.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            //published on
            news.time?.let {
                androidx.compose.material.Text(
                    text = "published on $it", modifier = Modifier
                        .alpha(0.6f)
                        .padding(start = 4.dp, top = 3.dp)
                )
            }

            //source and the author
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, top = 2.dp, bottom = 3.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                //source
                news.sourcePublication?.let {
                    Text(text = it, modifier = Modifier.alpha(0.6f))
                }

                //author
                news.author.let {
                    Text(
                        text = it.toString(), modifier = Modifier
                            .alpha(0.6f)
                            .padding(end = 20.dp)
                    )
                }
            }
        }
    }
}
