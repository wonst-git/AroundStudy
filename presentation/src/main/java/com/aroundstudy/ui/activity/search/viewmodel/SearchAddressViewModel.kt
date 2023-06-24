package com.aroundstudy.ui.activity.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.domain.usecase.server.kakao.GetAddressUseCase
import com.aroundstudy.util.LogUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchAddressViewModel @Inject constructor(private val kakaoAddressUseCase: GetAddressUseCase) : BaseViewModel() {

    private val _addressList = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf()
    }

    val addressList: LiveData<ArrayList<String>> get() = _addressList

    fun getSearchAddress(searchText: String) {
        viewModelScope.launch(Dispatchers.Main) {
            setLoading(true)

            _addressList.value?.clear()
            val result = kakaoAddressUseCase(searchText)
            val addressList = result.body()?.documents?.filter {
                it.addressType == "REGION" && (it.address.region3depthName.isNotEmpty() || it.address.region3depthHName.isNotEmpty())
            }?.map { it.addressName }?.filter { it.isNotEmpty() }
            LogUtil.d("addressList: ${result.body()}")
            LogUtil.d("addressList: $addressList")
            _addressList.value = ArrayList(addressList ?: listOf())

            setLoading(false)
        }
    }
}