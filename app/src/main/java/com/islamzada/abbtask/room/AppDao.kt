package com.islamzada.abbtask.room

import androidx.room.*
import com.islamzada.abbtask.data.model.CartModel

@Dao
interface AppDao {
    @Query("SELECT * FROM items")
    suspend fun loadItems() : List<CartModel>

    @Insert
    suspend fun insert(item:CartModel)

    @Delete
    suspend fun delete(item: CartModel)

    @Query("SELECT SUM(price) FROM items")
    suspend fun getTotalPrice(): Int
}