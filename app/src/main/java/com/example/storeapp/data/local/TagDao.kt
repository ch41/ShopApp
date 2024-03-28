package com.example.storeapp.data.local

import androidx.room.Dao

@Dao
abstract class TagDao : BaseDao<TagsEntity>("tags_entity")