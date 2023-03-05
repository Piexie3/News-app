package com.manubett.news.feature_onboading.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manubett.news.R
import com.manubett.news.ui.theme.DarkGreen40
import com.manubett.news.ui.theme.Green80
import com.manubett.news.ui.theme.Red80
import com.manubett.news.ui.theme.Violet40

@Composable
fun ViewPager3(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.post),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.extraLarge,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(alpha = 0.5f),
                contentColor = Color.Black
            ),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Green80,
                        DarkGreen40,
                        Violet40,
                        Red80
                    ),
                    tileMode = TileMode.Mirror
                )
            )
        ) {
            Text(text = "Get Started")
        }
    }
    
}