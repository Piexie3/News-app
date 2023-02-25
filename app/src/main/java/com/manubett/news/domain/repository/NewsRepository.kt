package com.manubett.news.domain.repository

import com.manubett.news.data.dto.NewsDto

interface NewsRepository  {
    suspend fun getNews(): NewsDto
}