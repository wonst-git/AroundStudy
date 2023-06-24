package com.aroundstudy.domain.usecase.database

import com.aroundstudy.domain.repository.database.SearchHistoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteAllSearchHistoryUseCase @Inject constructor(private val searchHistoryRepository: SearchHistoryRepository) {
    operator fun invoke(scope: CoroutineScope) {
        scope.launch(Dispatchers.IO) {
            searchHistoryRepository.deleteAll()
        }
    }
}