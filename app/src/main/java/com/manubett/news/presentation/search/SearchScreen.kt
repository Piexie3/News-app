package com.manubett.news.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manubett.news.R
import com.manubett.news.core.composables.SearchBar
import com.manubett.news.navigation.BottomNavItem
import com.manubett.news.navigation.BottomNavMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
//    navController: NavController
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
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "Any type of news and article",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ManageSearch,
                            contentDescription = "Filter"
                        )
                    }
                },
                backgroundColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )
        },
        bottomBar = {
            BottomAppBar {
//                BottomNavMenu(selectedItem = BottomNavItem.SEARCH, navController)
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { PaddingValues ->
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
                SearchBar(autoFocus = true) {
//                    searchViewModel.searchRemoteMovie(includeAdult.value ?: true)
                }
            }


//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(vertical = 12.dp)
//            ) {
//                when (searchResult.loadState.refresh) {
//                    is LoadState.NotLoading -> {
//                        items(searchResult) { film ->
//                            val focus = LocalFocusManager.current
//                            SearchResultItem(
//                                title = film!!.title,
//                                mediaType = film.mediaType,
//                                posterImage = "$BASE_POSTER_IMAGE_URL/${film.posterPath}",
//                                genres = homeViewModel.filmGenres.filter { genre ->
//                                    return@filter if (film.genreIds.isNullOrEmpty()) false else
//                                        film.genreIds.contains(genre.id)
//                                },
//                                rating = (film.voteAverage ?: 0) as Double,
//                                releaseYear = film.releaseDate,
//                                onClick = {
//                                    val navFilm = Film(
//                                        adult = film.adult ?: false,
//                                        backdropPath = film.backdropPath,
//                                        posterPath = film.posterPath,
//                                        genreIds = film.genreIds,
//                                        genres = film.genres,
//                                        mediaType = film.mediaType,
//                                        id = film.id ?: 0,
//                                        imdbId = film.imdbId,
//                                        originalLanguage = film.originalLanguage ?: "",
//                                        overview = film.overview ?: "",
//                                        popularity = film.popularity ?: 0F.toDouble(),
//                                        releaseDate = film.releaseDate ?: "",
//                                        runtime = film.runtime,
//                                        title = film.title ?: "",
//                                        video = film.video ?: false,
//                                        voteAverage = film.voteAverage ?: 0F.toDouble(),
//                                        voteCount = film.voteCount ?: 0
//                                    )
//                                    focus.clearFocus()
//                                    navigator.navigate(
//                                        direction = MovieDetailsDestination(
//                                            navFilm,
//                                            if (navFilm.mediaType == "tv") FilmType.TVSHOW else FilmType.MOVIE
//                                        )
//                                    ) {
//                                        launchSingleTop = true
//                                    }
//                                })
//                        }
//                        if (searchResult.itemCount == 0) {
//                            item {
//                                Box(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(top = 60.dp),
//                                    contentAlignment = Alignment.Center
//                                ) {
//                                    Image(
//                                        painter = painterResource(id = R.drawable.no_match_found),
//                                        contentDescription = null
//                                    )
//                                }
//
//                            }
//                        }
//                    }
//
//                    is LoadState.Loading -> item {
//                        if (searchViewModel.searchParam.value.isNotEmpty()) {
//                            Box(
//                                modifier = Modifier.fillMaxWidth(),
//                                contentAlignment = Alignment.Center
//                            ) {
//                                CircularProgressIndicator()
//                            }
//                        }
//                    }
//
//                    else -> item {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 60.dp),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.no_match_found),
//                                contentDescription = null
//                            )
//                        }
//                    }
//                }
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPrev() {
    SearchScreen()
}