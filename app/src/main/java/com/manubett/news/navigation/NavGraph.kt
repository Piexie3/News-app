package com.manubett.news.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.manubett.news.feature_posts.presentation.SharedViewModel
import com.manubett.news.feature_posts.presentation.SplashScreen
import com.manubett.news.feature_posts.presentation.bookmark.BookMarkScreen
import com.manubett.news.feature_posts.presentation.home.DetailScreen
import com.manubett.news.feature_posts.presentation.home.HomeScreen
import com.manubett.news.feature_posts.presentation.home.HomeViewModel
import com.manubett.news.feature_posts.presentation.profile.ProfileScreen
import com.manubett.news.feature_posts.presentation.search.SearchScreen
import com.manubett.news.feature_posts.presentation.trending.TrendingScreen

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
   NavHost(
       navController = navHostController,
       startDestination = Screens.HomeScreen.route
   ) {
       composable(Screens.HomeScreen.route){
           HomeScreen(navHostController,sharedViewModel)
       }
       composable(
           route= Screens.DetailScreen.route ){
           DetailScreen(navHostController,sharedViewModel)
       }
       composable(Screens.SearchScreen.route){
           SearchScreen(navHostController)
       }
       composable(Screens.TrendsScreen.route){
           TrendingScreen(navHostController)
       }
       composable(Screens.ProfileScreen.route){
           ProfileScreen(navHostController)
       }
       composable(Screens.BookMarkScreen.route){
           BookMarkScreen(navHostController)
       }
       composable(Screens.SplashScreen.route){
           SplashScreen()
       }
   }
}
