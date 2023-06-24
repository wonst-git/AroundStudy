package com.aroundstudy.domain.repository.database

import androidx.lifecycle.LiveData
import com.aroundstudy.domain.model.database.SearchHistory

interface SearchHistoryRepository {
    suspend fun insertSearchData(searchData: SearchHistory)
    suspend fun getSearchHistoryList(): LiveData<List<SearchHistory>>
    suspend fun delete(searchHistory: SearchHistory)
    suspend fun deleteAll()
}