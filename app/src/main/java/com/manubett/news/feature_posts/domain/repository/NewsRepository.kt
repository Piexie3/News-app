package com.manubett.news.feature_posts.domain.repository

import com.manubett.news.feature_posts.data.dto.newsDto.NewsDto

interface NewsRepository  {
    suspend fun getNews(): NewsDto
    suspend fun getNewsDetails(): NewsDto

    suspend fun searchNews(query:String): NewsDto
}