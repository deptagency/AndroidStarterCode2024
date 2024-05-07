package com.androidstartercode2024.domain.repositories

interface Repository {
    suspend fun getAnswer(): Result<Boolean>
}