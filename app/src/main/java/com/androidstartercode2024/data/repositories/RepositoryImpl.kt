package com.androidstartercode2024.data.repositories

import com.androidstartercode2024.data.sources.local.Database
import com.androidstartercode2024.data.sources.remote.api.API
import com.androidstartercode2024.domain.repositories.Repository

class RepositoryImpl(
    private val api: API,
    private val database: Database
) : Repository {
    override suspend fun getAnswer(): Result<Boolean> {
        val answer = true

        return Result.success(answer)
    }
}