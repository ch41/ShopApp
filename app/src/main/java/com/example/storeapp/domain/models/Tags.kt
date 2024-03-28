package com.example.storeapp.domain.models

data class Tags(
    val tagList: List<Category>
) {
    data class Category(
        val idCategory: String?,
        val strCategory: String?,
        val strCategoryDescription: String?,
        val strCategoryThumb: String?
    )
}