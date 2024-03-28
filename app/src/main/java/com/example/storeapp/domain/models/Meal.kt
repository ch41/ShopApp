package com.example.storeapp.domain.models

data class Meal(
    val mealList: List<Product>
) {
    data class Product(
        val idMeal: String?,
        val strArea: String?,
        val strCategory: String?,
        val strDrinkAlternate: Any?,
        val strImageSource: Any?,
        val ingredients: List<String?>,
        val strInstructions: String?,
        val strMeal: String?,
        val strMealThumb: String?,
        val strSource: String?,
        val strTags: String?,
    )
}