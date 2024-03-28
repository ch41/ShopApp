package com.example.storeapp.data.remote

import com.example.storeapp.data.models.ProductsResponse
import com.example.storeapp.data.models.TagsResponse
import retrofit2.http.GET

interface ProductService {

    @GET("search.php?s")
    suspend fun getProducts() : ProductsResponse

    @GET("categories.php")
    suspend fun getTags() : TagsResponse
}