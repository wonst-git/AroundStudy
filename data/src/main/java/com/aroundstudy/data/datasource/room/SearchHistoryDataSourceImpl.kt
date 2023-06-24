package com.aroundstudy.data.datasource.room

import androidx.lifecycle.LiveData
import com.aroundstudy.data.service.SearchHistoryDao
import com.aroundstudy.data.datamodel.database.SearchHistoryEntity
import javax.inject.Inject

class SearchHistoryDataSourceImpl @Inject constructor(private val searchHistoryDao: SearchHistoryDao) : SearchHistoryDataSource {
    override suspend fun insertSearchData(searchData: SearchHistoryEntity) = searchHistoryDao.insertSearchData(searchData)

    override suspend fun getSearchHistoryList(): LiveData<List<SearchHistoryEntity>> = searchHistoryDao.getSearchHistoryList()

    override suspend fun delete(searchHistoryEntity: SearchHistoryEntity) = searchHistoryDao.delete(searchHistoryEntity)

    override suspend fun deleteAll() = searchHistoryDao.deleteAll()
}