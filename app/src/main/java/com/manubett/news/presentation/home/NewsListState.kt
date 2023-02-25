package com.manubett.news.presentation.home

import com.manubett.news.domain.model.NewsItem

data class NewsListState(
    val isLoading: Boolean = false,
    val news: List<NewsItem> = emptyList(),
    val error: String = ""
)
