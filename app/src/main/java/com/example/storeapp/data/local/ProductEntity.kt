package com.example.storeapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@Entity(tableName = "product_entity")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val idMeal: String,
    val strArea: String?,
    val strCategory: String?,
    val strDrinkAlternate: String?,
    val strImageSource: String?,
    val ingredients: List<String?>,
    val strInstructions: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strSource: String?,
    val strTags: String?,
)


class Converters {
    @TypeConverter
    fun fromString(ingredients: String): List<String> {
        val gson = Gson()
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(ingredients, listType)
    }

    @TypeConverter
    fun fromList(ingredients: List<String?>): String {
        val gson = Gson()
        return gson.toJson(ingredients)
    }
}