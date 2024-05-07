package com.androidstartercode2024.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androidstartercode2024.data.sources.local.model.ExampleEntity
import com.androidstartercode2024.data.sources.local.persistance.ExampleEntityDAO

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun exampleEntityDAO(): ExampleEntityDAO
}