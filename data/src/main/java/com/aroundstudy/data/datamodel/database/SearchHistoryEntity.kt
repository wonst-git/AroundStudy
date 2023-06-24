package com.aroundstudy.data.datamodel.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aroundstudy.domain.model.database.SearchHistory
import kotlinx.parcelize.Parcelize

@Entity(tableName = "searchHistory")
@Parcelize
data class SearchHistoryEntity(
    @PrimaryKey val text: String,
    val date: Long
) : Parcelable, SearchHistory {
    override val searchText: String
        get() = text
    override val searchDate: Long
        get() = date
}