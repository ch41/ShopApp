package com.example.storeapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.storeapp.data.local.ProductDao
import com.example.storeapp.data.local.ProductDatabase
import com.example.storeapp.data.local.TagDao
import com.example.storeapp.data.local.TagsDatabase
import com.example.storeapp.data.remote.ProductService
import com.example.storeapp.data.repository.ConnectivityRepository
import com.example.storeapp.data.repository.MenuRepositoryImpl
import com.example.storeapp.domain.repository.MenuRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideMenuRepository(
        productService: ProductService,
        productDao: ProductDao,
        tagDao: TagDao
    ): MenuRepository = MenuRepositoryImpl(productService, tagDao, productDao)

    @Provides
    fun provideConnectivityRepository(@ApplicationContext context: Context): ConnectivityRepository =
        ConnectivityRepository(context)

    @Provides
    fun provideRetrofit() = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://themealdb.com/api/json/v1/1/")
        .build().create(ProductService::class.java)

    @Provides
    fun provideProductDao(database: ProductDatabase): ProductDao = database.productDao

    @Provides
    fun provideTagDao(database: TagsDatabase): TagDao = database.tagDao

    @Provides
    fun provideProductsDatabase(@ApplicationContext app: Context): ProductDatabase =
        Room.databaseBuilder(app, ProductDatabase::class.java, "product_entity").build()

    @Provides
    fun provideTagsDatabase(@ApplicationContext app: Context): TagsDatabase =
        Room.databaseBuilder(app, TagsDatabase::class.java, "tags_entity").build()
}