package com.aroundstudy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aroundstudy.data.service.SearchHistoryDao
import com.aroundstudy.data.datamodel.database.SearchHistoryEntity

@Database(entities = [SearchHistoryEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
}