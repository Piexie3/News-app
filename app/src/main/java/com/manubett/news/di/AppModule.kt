package com.manubett.news.di

import com.manubett.news.feature_posts.domain.use_cases.GetNewsUseCases
import com.manubett.news.core.util.Constants.BASE_URL
import com.manubett.news.feature_posts.data.remote.NewsApi
import com.manubett.news.feature_posts.data.repository.NewsRepositoryImpl
import com.manubett.news.feature_posts.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNewsApi(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(api: NewsApi): NewsRepository {
        return NewsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesGetNewsUseCase(repository: NewsRepository): GetNewsUseCases {
        return GetNewsUseCases(repository)
    }
}