package com.androidstartercode2024.domain.usecases

import com.androidstartercode2024.domain.repositories.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAnswerUseCase (
    private val repository: Repository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke() = withContext(defaultDispatcher) {
        repository.getAnswer()
    }
}