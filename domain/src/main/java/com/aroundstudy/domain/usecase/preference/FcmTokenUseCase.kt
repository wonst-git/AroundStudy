package com.aroundstudy.domain.usecase.preference

import com.aroundstudy.domain.repository.preference.PreferenceRepository
import javax.inject.Inject

class FcmTokenUseCase @Inject constructor(private val preferenceRepository: PreferenceRepository) {
    fun getFcmToken() = preferenceRepository.fcmToken
    fun setFcmToken(value: String) {
        preferenceRepository.fcmToken = value
    }
}