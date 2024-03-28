package com.example.storeapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags_entity")
data class TagsEntity(
    @PrimaryKey(autoGenerate = false)
    val idCategory: String,
    val strCategory: String?,
    val strCategoryDescription: String?,
    val strCategoryThumb: String?
)