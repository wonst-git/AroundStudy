package com.aroundstudy.ui.activity.splash.viewmodel

import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.domain.usecase.preference.FcmTokenUseCase
import com.aroundstudy.domain.usecase.preference.StartStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val fcmTokenUseCase: FcmTokenUseCase,
    private val startStateUseCase: StartStateUseCase
) : BaseViewModel() {

    val fcmToken = fcmTokenUseCase.getFcmToken()
    var startState = startStateUseCase.getStartState()

    fun saveFcmToken(token: String) = fcmTokenUseCase.setFcmToken(token)

    fun saveStartSate(state: Int) {
        startState = state
        startStateUseCase.setStartState(state)
    }
}