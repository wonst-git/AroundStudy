package com.aroundstudy.data.datasource.room

import androidx.lifecycle.LiveData
import com.aroundstudy.data.datamodel.database.SearchHistoryEntity

interface SearchHistoryDataSource {
    suspend fun insertSearchData(searchData: SearchHistoryEntity)
    suspend fun getSearchHistoryList(): LiveData<List<SearchHistoryEntity>>
    suspend fun delete(searchHistoryEntity: SearchHistoryEntity)
    suspend fun deleteAll()
}