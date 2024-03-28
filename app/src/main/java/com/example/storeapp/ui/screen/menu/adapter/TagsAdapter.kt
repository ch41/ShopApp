package com.example.storeapp.ui.screen.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.storeapp.databinding.TagRecyclerItemBinding
import com.example.storeapp.domain.models.Tags

class TagsAdapter :
    ListAdapter<Tags.Category, TagsAdapter.TagsViewHolder>(TagsDiffUtils()) {
    inner class TagsViewHolder(
        private val binding: TagRecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tag: Tags.Category) {
            with(binding) {
                tagTextView.text = tag.strCategory
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        return TagsViewHolder(
            TagRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}