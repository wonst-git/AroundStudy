package com.aroundstudy.ui.activity.start.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.domain.model.kakao.coord_address.CoordToAddressRes
import com.aroundstudy.domain.usecase.server.kakao.GetCoordToAddressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(private val getCoordToAddressUseCase: GetCoordToAddressUseCase) : BaseViewModel() {
    private val _nickname = MutableLiveData("")
    private val _region = MutableLiveData("")
    private val _coordAddress = MutableLiveData<CoordToAddressRes?>()

    val nickname: LiveData<String> get() = _nickname
    val region: LiveData<String> get() = _region
    val coordAddress: LiveData<CoordToAddressRes?> get() = _coordAddress
    var gender = 0
    var regionRange: Int = 1

    fun setNickname(nickname: String) {
        _nickname.value = nickname
    }

    fun setRegion(region: String) {
        _region.value = region
    }

    fun getCoordToAddress(latitude: Double, longitude: Double) {
        viewModelScope.launch(Dispatchers.Main) {
            setLoading(true)

            withContext(Dispatchers.IO) {
                val result = getCoordToAddressUseCase(longitude.toString(), latitude.toString())
                withContext(Dispatchers.Main) {
                    if (result.isSuccessful) {
                        _coordAddress.value = result.body()
                    } else {
                        _coordAddress.value = null
                    }
                }
            }

            withContext(Dispatchers.Main) {
                setLoading(false)
            }
        }
    }
}