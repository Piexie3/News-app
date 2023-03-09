package com.manubett.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.manubett.news.feature_posts.presentation.home.HomeViewModel
import com.manubett.news.feature_posts.presentation.profile.AuthorsProfileScreen
import com.manubett.news.navigation.NavGraph
import com.manubett.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    NavGraph()
                }
            }
        }
    }
}
