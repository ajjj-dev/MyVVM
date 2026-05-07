package com.aj.myvvm.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Items(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val item: String
)
