package com.example.storeapp.data.local

import androidx.room.Dao

@Dao
abstract class ProductDao : BaseDao<ProductEntity>("product_entity")