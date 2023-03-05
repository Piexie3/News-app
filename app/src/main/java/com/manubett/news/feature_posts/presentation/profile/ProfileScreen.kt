package com.manubett.news.feature_posts.presentation.profile

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manubett.news.navigation.BottomNavItem
import com.manubett.news.navigation.BottomNavMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(bottomBar = {
        BottomAppBar(
            modifier = Modifier
                .height(48.dp),
            containerColor = if (isSystemInDarkTheme())
                Color.Black.copy(.24f) else
                    Color.White.copy(.24f),
        ) {
            BottomNavMenu(selectedItem = BottomNavItem.PROFILE, navController)
        }
    }) { PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues.calculateBottomPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Profile Screen")
        }
    }
}