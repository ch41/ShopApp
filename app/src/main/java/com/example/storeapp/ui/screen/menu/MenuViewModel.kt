package com.example.storeapp.ui.screen.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.storeapp.R
import com.example.storeapp.data.repository.ConnectivityRepository
import com.example.storeapp.domain.Resource
import com.example.storeapp.domain.models.Images
import com.example.storeapp.domain.models.Meal
import com.example.storeapp.domain.models.Tags
import com.example.storeapp.domain.repository.MenuRepository
import com.example.storeapp.domain.use_case.GetProductsUseCase
import com.example.storeapp.domain.use_case.GetTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val connectivityRepository: ConnectivityRepository,
    private val getTagsUseCase: GetTagsUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val repository: MenuRepository
) : ViewModel() {


    init {
        getTags()
        getProducts()
    }

    val images = listOf(
        Images(
            R.drawable.top_image
        ), Images(
            R.drawable.top_image1
        )
    )

    val isInternetAvailable = connectivityRepository.isConnected.asLiveData()

    private val _tagState = MutableStateFlow(TagsState())
    val tagState: StateFlow<TagsState> get() = _tagState

    private val _productState = MutableStateFlow(ProductsState())
    val productState: StateFlow<ProductsState> get() = _productState


    private fun getTags() {
        viewModelScope.launch {
            val tags = getTagsUseCase().data?.tagList
            getTagsUseCase().data?.tagList?.let { repository.saveTags(it) }
            _tagState.value = TagsState(repository.getTagsFromLocalDb())
        }

    }

    private fun getProducts() {
        viewModelScope.launch {
            val products = getProductsUseCase().data?.mealList
            products?.let { repository.saveProducts(it) }
            _productState.value = ProductsState(repository.getProductsFromLocalDb())
        }
    }

}

data class TagsState(
    val tags: List<Tags.Category>? = emptyList(),
    val isLoading: Boolean = false,
    val isError: String = "",
)

data class ProductsState(
    val products: List<Meal.Product>? = emptyList(),
    val isLoading: Boolean = false,
    val isError: String = "",
)
