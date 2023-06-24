package com.aroundstudy.domain.usecase.database

import androidx.lifecycle.LiveData
import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.domain.repository.database.SearchHistoryRepository
import javax.inject.Inject

class GetSearchHistoryListUseCase @Inject constructor(private val searchHistoryRepository: SearchHistoryRepository) {
    suspend operator fun invoke(): LiveData<List<SearchHistory>> = searchHistoryRepository.getSearchHistoryList()
}