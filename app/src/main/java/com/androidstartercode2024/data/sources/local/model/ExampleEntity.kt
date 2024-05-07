package com.androidstartercode2024.data.sources.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example")
data class ExampleEntity(
    @PrimaryKey
    val name: String
)
