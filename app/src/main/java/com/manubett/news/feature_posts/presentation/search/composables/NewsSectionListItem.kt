package com.manubett.news.feature_posts.presentation.search.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.manubett.news.R
import com.manubett.news.feature_posts.domain.model.NewsDetails
import com.manubett.news.feature_posts.domain.model.NewsItem
import com.manubett.news.feature_posts.presentation.SharedViewModel
import com.manubett.news.navigation.Screens

@Composable
fun NewsSectionListItem(
    searchNewsItem: NewsItem,
    navController: NavController,
    sharedNewsDetailsViewModel: SharedViewModel,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable {

                val newsDetails = NewsDetails(
                    image = searchNewsItem.image,
                    title = searchNewsItem.title,
                    headline = searchNewsItem.headline,
                    time = searchNewsItem.time,
                    author = searchNewsItem.author,
                    authorsImage = searchNewsItem.authorsImage,
                    ratings = searchNewsItem.ratings,
                    sourcePublication = searchNewsItem.sourcePublication,
                    sectionName = searchNewsItem.sectionName,
                    bodyText = searchNewsItem.bodyText,
                    trailText = searchNewsItem.trailText,
                    body = searchNewsItem.body,
                    productionOffice = searchNewsItem.productionOffice,
                    lastModified = searchNewsItem.lastModified,
                    twitterHandle = searchNewsItem.twitterHandle,
                    bio = searchNewsItem.bio,
                    firstName = searchNewsItem.firstName,
                    description = searchNewsItem.description,
                    tagId = searchNewsItem.tagId,
                    resultId = searchNewsItem.resultId,
                    lastName = searchNewsItem.lastName,
                    fullNames = searchNewsItem.fullNames,
                    id = searchNewsItem.id
                )

                //add details to shared details viewModel
                sharedNewsDetailsViewModel.addDetails(newsDetails)

                Log.d("section dettails", newsDetails.headline.toString())

                //pass all those details to details screen
                navController.navigate(route = Screens.DetailScreen.route) {
                    popUpTo(Screens.DetailScreen.route) {
                        inclusive = true
                    }
                }
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(searchNewsItem.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = searchNewsItem.title,
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
            searchNewsItem.headline?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(start = 4.dp, top = 1.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            //published on
            searchNewsItem.time?.let {
                Text(
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
                searchNewsItem.sourcePublication?.let {
                    Text(text = it, modifier = Modifier.alpha(0.6f))
                }

                //author
                searchNewsItem.author.let {
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
