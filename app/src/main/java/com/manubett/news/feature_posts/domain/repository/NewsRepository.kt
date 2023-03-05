package com.manubett.news.feature_posts.domain.repository

import com.manubett.news.feature_posts.data.dto.NewsDto

interface NewsRepository  {
    suspend fun getNews(): NewsDto

    suspend fun searchNews(query:String): NewsDto
}