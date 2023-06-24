package com.aroundstudy.data.service

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aroundstudy.data.datamodel.database.SearchHistoryEntity

@Dao
interface SearchHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearchData(searchData: SearchHistoryEntity)

    @Query("SELECT * FROM searchHistory ORDER BY date DESC")
    fun getSearchHistoryList(): LiveData<List<SearchHistoryEntity>>

    @Delete
    fun delete(searchHistoryEntity: SearchHistoryEntity)

    @Query("DELETE FROM searchHistory")
    fun deleteAll()
}