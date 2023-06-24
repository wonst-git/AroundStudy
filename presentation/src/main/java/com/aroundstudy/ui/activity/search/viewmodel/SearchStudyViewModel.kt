package com.aroundstudy.ui.activity.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aroundstudy.base.BaseViewModel
import com.aroundstudy.data.datamodel.database.SearchHistoryEntity
import com.aroundstudy.data.datamodel.server.study.StudyDataEntity
import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.domain.usecase.database.DeleteAllSearchHistoryUseCase
import com.aroundstudy.domain.usecase.database.DeleteSearchHistoryUseCase
import com.aroundstudy.domain.usecase.database.GetSearchHistoryListUseCase
import com.aroundstudy.domain.usecase.database.InsertSearchHistoryUseCase
import com.aroundstudy.util.TestUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchStudyViewModel @Inject constructor(
    private val getSearchHistoryListUseCase: GetSearchHistoryListUseCase,
    private val deleteSearchHistoryUseCase: DeleteSearchHistoryUseCase,
    private val deleteAllSearchHistoryUseCase: DeleteAllSearchHistoryUseCase,
    private val insertSearchHistoryUseCase: InsertSearchHistoryUseCase
) : BaseViewModel() {

    private val _hotStudyList = MutableLiveData(TestUtil.testHotStudyList)
    private val _selectedCategoryList = MutableLiveData<MutableSet<String>>(mutableSetOf())

    val hotStudyList: LiveData<ArrayList<StudyDataEntity>> get() = _hotStudyList
    val selectedCategoryList: LiveData<MutableSet<String>> get() = _selectedCategoryList
    val categoryList = TestUtil.testCategoryList
    val studyList = TestUtil.testStudyList

    fun addSelectedCategoryList(category: String) {
        _selectedCategoryList.value = _selectedCategoryList.value?.apply {
            add(category)
        }
    }

    fun removeSelectedCategoryList(category: String) {
        _selectedCategoryList.value = _selectedCategoryList.value?.apply {
            remove(category)
        }
    }

    fun removeAllSelectedCategoryList() {
        _selectedCategoryList.value = mutableSetOf()
    }

    suspend fun getSearchHistoryList() = getSearchHistoryListUseCase()

    fun deleteSearchHistory(searchData: SearchHistory) = deleteSearchHistoryUseCase(searchData, viewModelScope)

    fun deleteAllSearchHistory() = deleteAllSearchHistoryUseCase(viewModelScope)

    fun insertSearchHistory(searchText: String) {
        insertSearchHistoryUseCase(SearchHistoryEntity(text = searchText, date = System.currentTimeMillis()), viewModelScope)
    }
}
