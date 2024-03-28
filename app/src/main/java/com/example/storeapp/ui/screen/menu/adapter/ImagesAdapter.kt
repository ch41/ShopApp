package com.example.storeapp.ui.screen.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.storeapp.databinding.TopRecyclerItemBinding
import com.example.storeapp.domain.models.Images

class ImagesAdapter : ListAdapter<Images, ImagesAdapter.ImagesViewHolder>(ImageDiffUtil()) {

    inner class ImagesViewHolder(
        private val binding: TopRecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Images) {
            with(binding) {
                imageView.setImageResource(image.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder(
            TopRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}