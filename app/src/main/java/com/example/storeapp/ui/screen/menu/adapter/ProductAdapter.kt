package com.example.storeapp.ui.screen.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.storeapp.databinding.ProductRecyclerItemBinding
import com.example.storeapp.databinding.TagRecyclerItemBinding
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.models.Tags

class ProductAdapter :
    ListAdapter<Meal.Product, ProductAdapter.ProductViewHolder>(ProductDiffUtil()) {
    inner class ProductViewHolder(
        private val binding: ProductRecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal.Product) {
            with(binding) {
                productImageView.load(meal.strMealThumb)
                productTitleTextView.text = meal.strMeal
                ingredientsTextView.text = meal.ingredients.filter { it?.isNotBlank() ?: false }.joinToString()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}