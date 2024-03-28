package com.example.storeapp.ui.screen.menu.adapter


import androidx.recyclerview.widget.DiffUtil
import com.example.storeapp.domain.models.Images
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.models.Tags

class TagsDiffUtils : DiffUtil.ItemCallback<Tags.Category>() {
    override fun areItemsTheSame(oldItem: Tags.Category, newItem: Tags.Category): Boolean {
        return oldItem.idCategory == newItem.idCategory
    }

    override fun areContentsTheSame(oldItem: Tags.Category, newItem: Tags.Category): Boolean {
        return oldItem == newItem
    }
}
class ProductDiffUtil : DiffUtil.ItemCallback<Meal.Product>() {
    override fun areItemsTheSame(oldItem: Meal.Product, newItem: Meal.Product): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: Meal.Product, newItem: Meal.Product): Boolean {
        return oldItem == newItem
    }
}
class ImageDiffUtil : DiffUtil.ItemCallback<Images>() {
    override fun areItemsTheSame(oldItem: Images, newItem: Images): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Images, newItem: Images): Boolean {
        return oldItem == newItem
    }
}