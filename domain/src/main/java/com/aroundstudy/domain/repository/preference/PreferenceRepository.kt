package com.aroundstudy.domain.repository.preference

interface PreferenceRepository {
    var fcmToken: String
    var startState: Int
}