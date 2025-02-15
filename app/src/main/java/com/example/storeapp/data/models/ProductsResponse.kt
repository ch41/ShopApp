package com.example.storeapp.data.models


import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("meals")
    val meals: List<Meal>
) {
    data class Meal(
        @SerializedName("dateModified")
        val dateModified: Any?,
        @SerializedName("idMeal")
        val idMeal: String?,
        @SerializedName("strArea")
        val strArea: String?,
        @SerializedName("strCategory")
        val strCategory: String?,
        @SerializedName("strCreativeCommonsConfirmed")
        val strCreativeCommonsConfirmed: Any?,
        @SerializedName("strDrinkAlternate")
        val strDrinkAlternate: Any?,
        @SerializedName("strImageSource")
        val strImageSource: Any?,
        @SerializedName("strIngredient1")
        val strIngredient1: String?,
        @SerializedName("strIngredient10")
        val strIngredient10: String?,
        @SerializedName("strIngredient11")
        val strIngredient11: String?,
        @SerializedName("strIngredient12")
        val strIngredient12: String?,
        @SerializedName("strIngredient13")
        val strIngredient13: String?,
        @SerializedName("strIngredient14")
        val strIngredient14: String?,
        @SerializedName("strIngredient15")
        val strIngredient15: String?,
        @SerializedName("strIngredient16")
        val strIngredient16: String?,
        @SerializedName("strIngredient17")
        val strIngredient17: String?,
        @SerializedName("strIngredient18")
        val strIngredient18: String?,
        @SerializedName("strIngredient19")
        val strIngredient19: String?,
        @SerializedName("strIngredient2")
        val strIngredient2: String?,
        @SerializedName("strIngredient20")
        val strIngredient20: String?,
        @SerializedName("strIngredient3")
        val strIngredient3: String?,
        @SerializedName("strIngredient4")
        val strIngredient4: String?,
        @SerializedName("strIngredient5")
        val strIngredient5: String?,
        @SerializedName("strIngredient6")
        val strIngredient6: String?,
        @SerializedName("strIngredient7")
        val strIngredient7: String?,
        @SerializedName("strIngredient8")
        val strIngredient8: String?,
        @SerializedName("strIngredient9")
        val strIngredient9: String?,
        @SerializedName("strInstructions")
        val strInstructions: String?,
        @SerializedName("strMeal")
        val strMeal: String?,
        @SerializedName("strMealThumb")
        val strMealThumb: String?,
        @SerializedName("strSource")
        val strSource: String?,
        @SerializedName("strTags")
        val strTags: String?,
    )
}