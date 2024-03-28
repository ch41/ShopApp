package com.example.storeapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
abstract class BaseDao<T>(private val tableName: String) {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: List<T>)

    @RawQuery
    protected abstract fun getAll(query: SupportSQLiteQuery): List<T>

    fun getAll(): List<T> {
        val query = SimpleSQLiteQuery("select * from $tableName")
        return getAll(query)
    }
}