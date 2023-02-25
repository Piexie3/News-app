package com.manubett.bettanews.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.manubett.news.data.dto.NewsDto
import com.manubett.bettanews.data.remote.NewsApi
import com.manubett.news.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getNews(): NewsDto {
       return api.getAllNews()
    }
}