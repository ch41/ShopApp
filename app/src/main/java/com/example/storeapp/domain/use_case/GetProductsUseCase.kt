package com.example.storeapp.domain.use_case

import com.example.storeapp.domain.Resource
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.repository.MenuRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: MenuRepository
) {
    suspend operator fun invoke(): Resource<Meal> {
        return repository.getProducts()
    }
}