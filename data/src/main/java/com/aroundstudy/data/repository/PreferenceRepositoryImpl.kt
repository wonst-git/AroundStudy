package com.aroundstudy.data.repository

import com.aroundstudy.data.datasource.preference.PreferenceDatasource
import com.aroundstudy.domain.repository.preference.PreferenceRepository
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(private val preferenceDatasource: PreferenceDatasource) : PreferenceRepository {
    override var fcmToken: String
        get() = preferenceDatasource.fcmToken
        set(value) {
            preferenceDatasource.fcmToken = value
        }

    override var startState: Int
        get() = preferenceDatasource.startState
        set(value) {
            preferenceDatasource.startState = value
        }
}