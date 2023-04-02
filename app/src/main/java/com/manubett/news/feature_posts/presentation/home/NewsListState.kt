package com.manubett.news.feature_posts.presentation.home

import com.manubett.news.feature_posts.domain.model.NewsItem

data class NewsListState(
    val isLoading: Boolean = false,
    val news: List<NewsItem>? = null,
    val error: String = "",
)
