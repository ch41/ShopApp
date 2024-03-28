package com.example.storeapp.ui.screen.menu

import android.util.Log
import com.example.storeapp.common.base.BaseFragment
import com.example.storeapp.databinding.MenuFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.storeapp.ui.screen.menu.adapter.ImagesAdapter
import com.example.storeapp.ui.screen.menu.adapter.ProductAdapter
import com.example.storeapp.ui.screen.menu.adapter.TagsAdapter
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : BaseFragment<MenuFragmentBinding>(MenuFragmentBinding::inflate) {

    private val viewModel: MenuViewModel by viewModels()

    override fun MenuFragmentBinding.initialize() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tagState.collect { tagsState ->
                val adapter = TagsAdapter()
                adapter.submitList(tagsState.tags)
                binding.tagsRecyclerView.adapter = adapter
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.productState.collect { productState ->
                val adapter = ProductAdapter()
                adapter.submitList(productState.products)
                binding.productRecyclerView.adapter = adapter
            }
        }

        viewModel.isInternetAvailable.observe(viewLifecycleOwner) { isOnline ->
            if (isOnline) {
                Log.d("isOnline", "initialize: true ")
            } else {
                Log.d("isOnline", "initialize: false ")
            }
        }
        setImages()
    }

    private fun setImages(){
        val adapter = ImagesAdapter()
        adapter.submitList(viewModel.images)
        binding.imagesRecyclerView.adapter = adapter
    }

}