package com.example.storeapp.domain.use_case

import com.example.storeapp.domain.Resource
import com.example.storeapp.domain.models.Tags
import com.example.storeapp.domain.repository.MenuRepository
import javax.inject.Inject

class GetTagsUseCase @Inject constructor(
    private val repository: MenuRepository
) {
    suspend operator fun invoke(): Resource<Tags> {
        return repository.getTags()
    }
}