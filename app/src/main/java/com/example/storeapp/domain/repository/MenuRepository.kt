package com.example.storeapp.domain.repository

import com.example.storeapp.data.local.TagsEntity
import com.example.storeapp.domain.Resource
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.models.Tags
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getProducts() : Resource<Meal>
    suspend fun getTags() : Resource<Tags>
    suspend fun saveTags(tags: List<Tags.Category>)
    suspend fun saveProducts(products: List<Meal.Product>)
    suspend fun getTagsFromLocalDb() : List<Tags.Category>
    suspend fun getProductsFromLocalDb() : List<Meal.Product>
}