package com.aroundstudy.domain.usecase.database

import com.aroundstudy.domain.model.database.SearchHistory
import com.aroundstudy.domain.repository.database.SearchHistoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteSearchHistoryUseCase @Inject constructor(private val historyRepository: SearchHistoryRepository) {
    operator fun invoke(historyData: SearchHistory, scope: CoroutineScope) {
        scope.launch(Dispatchers.IO) {
            historyRepository.delete(historyData)
        }
    }
}