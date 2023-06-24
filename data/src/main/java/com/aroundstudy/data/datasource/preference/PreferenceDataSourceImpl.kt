package com.aroundstudy.data.datasource.preference

import com.aroundstudy.data.service.PreferenceManager
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(private val preferenceManager: PreferenceManager) : PreferenceDatasource {
    override var fcmToken: String
        get() = preferenceManager.fcmToken
        set(value) {
            preferenceManager.fcmToken = value
        }

    override var startState: Int
        get() = preferenceManager.startState
        set(value) {
            preferenceManager.startState = value
        }
}