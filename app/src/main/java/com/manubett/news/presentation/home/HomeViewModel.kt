package com.manubett.news.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manubett.bettanews.domain.use_cases.GetNewsUseCases
import com.manubett.news.core.util.Resource
import com.manubett.news.domain.model.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCases: GetNewsUseCases,
) : ViewModel() {
    private val _newsListState = mutableStateOf(NewsListState())
    val newsListState: State<NewsListState> = _newsListState

    private val _newsDetailsState = mutableStateOf(NewsListState())
    val newsDetailsState: State<NewsListState> = _newsDetailsState

    init {
        getArticles()
        getDetails()
    }
    var details by mutableStateOf<NewsItem?>(null)
        private set

    fun addDetails(newsDetails : NewsItem){
        details = newsDetails
    }


    private fun getArticles() {

        getNewsUseCases().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _newsListState.value = NewsListState(news = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _newsListState.value = NewsListState(isLoading = true)
                }
                is Resource.Error -> {
                    _newsListState.value =
                        NewsListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getDetails() {
        getNewsUseCases().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _newsDetailsState.value = NewsListState(news = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _newsDetailsState.value = NewsListState(isLoading = true)
                }
                is Resource.Error -> {
                    _newsDetailsState.value =
                        NewsListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}