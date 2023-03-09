package com.manubett.news.feature_posts.domain.use_cases

import com.manubett.news.core.util.Resource
import com.manubett.news.feature_posts.data.dto.toNewsItem
import com.manubett.news.feature_posts.domain.model.NewsItem
import com.manubett.news.feature_posts.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val repository: NewsRepository,
) {

    operator fun invoke(query: String): Flow<Resource<List<NewsItem>>> = flow {
        try {
            emit(Resource.Loading<List<NewsItem>>())

            val newsList = repository.searchNews(query = query).toNewsItem()

            emit(Resource.Success<List<NewsItem>>(newsList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: Exception) {
            emit(Resource.Error("Something unexpected happened. Please try again"))
        }
    }
}
