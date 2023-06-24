package com.aroundstudy.domain.usecase.database

import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.domain.repository.database.SearchHistoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class InsertSearchHistoryUseCase @Inject constructor(private val searchHistoryRepository: SearchHistoryRepository) {
    operator fun invoke(searchData: SearchHistory, scope: CoroutineScope) {
        scope.launch(Dispatchers.IO) {
            searchHistoryRepository.insertSearchData(searchData)
        }
    }
}