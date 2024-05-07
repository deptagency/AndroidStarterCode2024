package com.androidstartercode2024.data.sources.local.persistance

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExampleEntityDAO {

    @Query("SELECT * FROM example")
    fun getName(): Flow<String>
}