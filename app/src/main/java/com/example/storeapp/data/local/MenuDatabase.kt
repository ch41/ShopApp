package com.example.storeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ProductDatabase: RoomDatabase() {
    abstract val productDao: ProductDao
}

@Database(
    entities = [TagsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TagsDatabase : RoomDatabase() {
    abstract val tagDao: TagDao
}


