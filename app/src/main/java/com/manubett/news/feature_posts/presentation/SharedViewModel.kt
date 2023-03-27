package com.manubett.news.feature_posts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.manubett.news.feature_posts.domain.model.NewsDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
@Inject
constructor(
//        private val newsDetailsUseCase: NewsDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    var searchedKeyWord by mutableStateOf<String?>(null)
        private set


    var details by mutableStateOf<NewsDetails?>(null)
        private set


    fun addDetails(newsDetails: NewsDetails) {
        details = newsDetails
    }

    fun addSearchedKeyWord(keyword: String) {
        searchedKeyWord = keyword
    }
}