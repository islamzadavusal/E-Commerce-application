package com.islamzada.abbtask.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.islamzada.abbtask.data.model.CartModel

@Database(entities = [CartModel::class], version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getItemsDao() : AppDao
}