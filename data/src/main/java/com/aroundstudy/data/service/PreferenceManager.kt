package com.aroundstudy.data.service

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val aroundPref: SharedPreferences = context.getSharedPreferences(AROUND_STUDY, Context.MODE_PRIVATE)

    var fcmToken: String
        get() = aroundPref.getString(FCM_TOKEN, "").toString()
        set(value) =
            aroundPref.edit().run {
                putString(FCM_TOKEN, value)
                apply()
            }

    var startState: Int
        get() = aroundPref.getInt(START_STATE, 0)
        set(value) =
            aroundPref.edit().run {
                putInt(START_STATE, value)
                apply()
            }

    companion object {
        private const val AROUND_STUDY = "aroundStudy"

        const val FCM_TOKEN = "fcmToken"
        const val START_STATE = "startState"
    }
}