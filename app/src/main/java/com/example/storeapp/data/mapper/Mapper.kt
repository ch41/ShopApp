package com.example.storeapp.data.mapper

import com.example.storeapp.data.local.ProductEntity
import com.example.storeapp.data.local.TagsEntity
import com.example.storeapp.data.models.ProductsResponse
import com.example.storeapp.data.models.TagsResponse
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.models.Tags

fun TagsResponse.toDomain(): Tags {
    return Tags(
        tagList = this.categories.map {
            Tags.Category(
                idCategory = it.idCategory,
                strCategory = it.strCategory,
                strCategoryDescription = it.strCategoryDescription,
                strCategoryThumb = it.strCategoryThumb
            )
        }
    )
}

fun ProductsResponse.toDomain(): Meal {
    return Meal(
        mealList = this.meals.map {
            Meal.Product(
                idMeal = it.idMeal,
                strArea = it.strArea,
                strCategory = it.strCategory,
                strDrinkAlternate = it.strDrinkAlternate,
                strImageSource = it.strImageSource,
                strInstructions = it.strInstructions,
                strMeal = it.strMeal,
                strMealThumb = it.strMealThumb,
                strSource = it.strSource,
                strTags = it.strTags,
                ingredients = listOf(
                    it.strIngredient1,
                    it.strIngredient2,
                    it.strIngredient3,
                    it.strIngredient4,
                    it.strIngredient5,
                    it.strIngredient6,
                    it.strIngredient7,
                    it.strIngredient8,
                    it.strIngredient9,
                    it.strIngredient10,
                    it.strIngredient11,
                    it.strIngredient12,
                    it.strIngredient13,
                    it.strIngredient14,
                    it.strIngredient15,
                    it.strIngredient16,
                    it.strIngredient17,
                    it.strIngredient18,
                    it.strIngredient19,
                    it.strIngredient20,
                )
            )
        }
    )
}

fun List<TagsEntity>.toDomain() : Tags {
    return Tags(
        tagList = this.map {
            Tags.Category(
                idCategory = it.idCategory,
                strCategory = it.strCategory,
                strCategoryDescription = it.strCategoryDescription,
                strCategoryThumb = it.strCategoryThumb
            )
        }
    )
}

fun List<ProductEntity>.toDomain(): Meal {
    return Meal(
        mealList = this.map {
            Meal.Product(
                idMeal = it.idMeal,
                strArea = it.strArea,
                strCategory = it.strCategory,
                strDrinkAlternate = it.strDrinkAlternate,
                strImageSource = it.strImageSource,
                strInstructions = it.strInstructions,
                strMeal = it.strMeal,
                strMealThumb = it.strMealThumb,
                strSource = it.strSource,
                strTags = it.strTags,
                ingredients = it.ingredients
            )
        }
    )
}
fun List<Meal.Product>.toLocalEntity() : List<ProductEntity> {
    return this.map {
                ProductEntity(
                    idMeal = it.idMeal!!,
                    strArea = it.strArea,
                    strCategory = it.strCategory,
                    strDrinkAlternate = it.strDrinkAlternate.toString(),
                    strImageSource = it.strImageSource.toString(),
                    strInstructions = it.strInstructions,
                    strMeal = it.strMeal,
                    strMealThumb = it.strMealThumb,
                    strSource = it.strSource,
                    strTags = it.strTags,
                    ingredients = it.ingredients
                )
    }
}
fun List<Tags.Category>.toEntity() : List<TagsEntity>{
    return this.map {
        TagsEntity(
            idCategory = it.idCategory!!,
            strCategory = it.strCategory,
            strCategoryDescription = it.strCategoryDescription,
            strCategoryThumb = it.strCategoryThumb
        )
    }
}