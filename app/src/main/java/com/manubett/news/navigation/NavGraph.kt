package com.manubett.news.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manubett.news.presentation.bookmark.BookMarkScreen
import com.manubett.news.presentation.home.DetailScreen
import com.manubett.news.presentation.home.HomeScreen
import com.manubett.news.presentation.home.HomeViewModel
import com.manubett.news.presentation.profile.ProfileScreen
import com.manubett.news.presentation.search.SearchScreen
import com.manubett.news.presentation.trending.TrendingScreen

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
    viewModel: HomeViewModel = hiltViewModel()
) {
   NavHost(
       navController = navHostController,
       startDestination = Screens.HomeScreen.route
   ) {
       composable(Screens.HomeScreen.route){
           HomeScreen(navHostController)
       }
       composable(Screens.DetailScreen.route){
           DetailScreen(navHostController,viewModel)
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
   }
}
