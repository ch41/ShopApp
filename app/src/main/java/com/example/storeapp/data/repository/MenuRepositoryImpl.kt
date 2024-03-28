package com.example.storeapp.data.repository

import com.example.storeapp.data.local.ProductDao
import com.example.storeapp.data.local.ProductEntity
import com.example.storeapp.data.local.TagDao
import com.example.storeapp.data.local.TagsEntity
import com.example.storeapp.data.mapper.toDomain
import com.example.storeapp.data.mapper.toEntity
import com.example.storeapp.data.mapper.toLocalEntity
import com.example.storeapp.data.remote.ProductService
import com.example.storeapp.domain.Resource
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.models.Tags
import com.example.storeapp.domain.repository.MenuRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val productService: ProductService,
    private val tagsDao: TagDao,
    private val productDao: ProductDao
//    private val dispatcher: Dispatcher

) : MenuRepository {
    override suspend fun getProducts(): Resource<Meal> {
        return try {
            val products = productService.getProducts().toDomain()
            Resource.Success(products)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error")
        }
    }

    override suspend fun getTags(): Resource<Tags> {
        return try {
            val tags = productService.getTags().toDomain()
            Resource.Success(tags)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error")
        }
    }
    override suspend fun saveTags(tags: List<Tags.Category>){
        withContext(Dispatchers.IO) {
            tagsDao.insert(tags.toEntity())
        }
    }
    override suspend fun saveProducts(products: List<Meal.Product>){
        withContext(Dispatchers.IO) {
            productDao.insert(products.toLocalEntity())
        }
    }
    override suspend fun getTagsFromLocalDb() : List<Tags.Category> {
        return withContext(Dispatchers.IO){
            tagsDao.getAll().toDomain().tagList
        }
    }
    override suspend fun getProductsFromLocalDb() : List<Meal.Product> {
        return withContext(Dispatchers.IO){
            productDao.getAll().toDomain().mealList
        }
    }
}