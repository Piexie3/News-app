package com.manubett.news.feature_onboading.data.repository

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.manubett.news.core.util.Constants
import com.manubett.news.feature_onboading.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val app: Application
): OnBoardingRepository {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "prefs")
        private val FINISHED_ON_BOARDING = booleanPreferencesKey(Constants.FINISHED_ON_BOARDING)
    }


    override suspend fun setOnBoardingFinished(finished: Boolean) {
        app.applicationContext.dataStore.edit { prefs ->
            prefs[FINISHED_ON_BOARDING] = finished
        }
    }
    override fun getOnBoardingFinished(): Flow<Boolean> {
        val finishedOnBoarding: Flow<Boolean> = app.applicationContext.dataStore.data
            .map { prefs ->
                prefs[FINISHED_ON_BOARDING] ?: false
            }
        return finishedOnBoarding
    }
}