package com.aroundstudy.ui.activity.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.domain.usecase.database.GetSearchHistoryListUseCase
import com.aroundstudy.domain.usecase.database.InsertSearchHistoryUseCase
import com.aroundstudy.util.TestUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSearchHistoryListUseCase: GetSearchHistoryListUseCase,
    private val insertSearchHistoryUseCase: InsertSearchHistoryUseCase,
) : BaseViewModel() {

    //testData
    private val _categoryList = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    private val _studyList = MutableLiveData<ArrayList<StudyDataEntity>>().apply { value = arrayListOf() }

    val categoryList: LiveData<ArrayList<String>> get() = _categoryList
    val studyList: LiveData<ArrayList<StudyDataEntity>> get() = _studyList

    init {
        _categoryList.value = _categoryList.value?.apply { addAll(TestUtil.testCategoryList) }
        _studyList.value = _studyList.value?.apply { addAll(TestUtil.testStudyList) }
    }

    suspend fun getSearchHistoryList(): LiveData<List<SearchHistory>> {
        return getSearchHistoryListUseCase.invoke()
    }

    fun insertSearchHistoryList(searchData: SearchHistory) {
        insertSearchHistoryUseCase.invoke(searchData, viewModelScope)
    }
}