package com.manubett.bettanews.domain.use_cases

import android.util.Log
import com.manubett.news.core.util.Resource
import com.manubett.news.data.dto.toNewsItem
import com.manubett.news.domain.model.NewsItem
import com.manubett.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCases @Inject constructor(
    private val repository: NewsRepository
) {
    val Tag = "GetNewsUseCases"
    operator fun invoke(): Flow<Resource<List<NewsItem>>> = flow {
        try {
            emit(Resource.Loading())
            val article = repository.getNews().toNewsItem()
                Log.d(Tag, "Something happened")
            emit(Resource.Success(article))

        }catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"An  unexpected Error occurred!"))

        }catch(e: IOException){
            emit(Resource.Error("Couldn't reach server. Please check your Internet Connections "))
        }
    }
}