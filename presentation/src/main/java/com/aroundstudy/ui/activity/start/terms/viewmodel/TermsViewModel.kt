package com.aroundstudy.ui.activity.start.terms.viewmodel

import androidx.lifecycle.MutableLiveData
import com.aroundstudy.base.BaseViewModel

class TermsViewModel : BaseViewModel() {
    private val _checkedList = MutableLiveData<MutableSet<Int>>(mutableSetOf())
    val checkedList get() = _checkedList

    fun addCheck(ids: List<Int>) {
        _checkedList.postValue(_checkedList.value?.apply { addAll(ids.toSet()) })
    }

    fun removeCheck(ids: List<Int>) {
        _checkedList.postValue(_checkedList.value?.apply { removeAll(ids.toSet()) })
    }
}