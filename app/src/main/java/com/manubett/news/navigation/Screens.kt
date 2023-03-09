package com.manubett.news.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens("Home_screen")
    object SearchScreen : Screens("Search_screen")
    object ProfileScreen : Screens("Profile_screen")
    object TrendsScreen : Screens("Trend_Screen")
    object BookMarkScreen : Screens("BookMark_Screen")
    object DetailScreen : Screens("Detail_Screen")
    object SplashScreen : Screens("Splash_Screen")
}