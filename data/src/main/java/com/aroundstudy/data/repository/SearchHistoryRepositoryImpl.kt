package com.aroundstudy.data.repository

import androidx.lifecycle.LiveData
import com.aroundstudy.data.datamodel.database.SearchHistoryEntity
import com.aroundstudy.data.datasource.room.SearchHistoryDataSource
import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.domain.repository.database.SearchHistoryRepository
import javax.inject.Inject

class SearchHistoryRepositoryImpl @Inject constructor(private val searchHistoryDataSource: SearchHistoryDataSource) : SearchHistoryRepository {
    @Suppress("UNCHECKED_CAST")
    override suspend fun getSearchHistoryList() = searchHistoryDataSource.getSearchHistoryList() as LiveData<List<SearchHistory>>
    override suspend fun insertSearchData(searchData: SearchHistory) = searchHistoryDataSource.insertSearchData(searchData as SearchHistoryEntity)
    override suspend fun delete(searchHistory: SearchHistory) = searchHistoryDataSource.delete(searchHistory as SearchHistoryEntity)
    override suspend fun deleteAll() = searchHistoryDataSource.deleteAll()
}