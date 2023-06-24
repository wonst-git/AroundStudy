package com.aroundstudy.domain.usecase.preference

import com.aroundstudy.domain.repository.preference.PreferenceRepository
import javax.inject.Inject

class StartStateUseCase @Inject constructor(private val preferenceRepository: PreferenceRepository) {
    fun getStartState() = preferenceRepository.startState
    fun setStartState(value: Int) {
        preferenceRepository.startState = value
    }
}