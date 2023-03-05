package com.manubett.news.feature_posts.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.manubett.news.feature_posts.data.dto.NewsDto
import com.manubett.news.feature_posts.data.remote.NewsApi
import com.manubett.news.feature_posts.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getNews(): NewsDto {
       return api.getAllNews()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun searchNews(query: String): NewsDto {
        return api.searchNews(query= query)
    }
}