package com.islamzada.abbtask.data.repo

import com.islamzada.abbtask.data.datasource.ItemDatasource
import com.islamzada.abbtask.data.model.CartModel

class ItemRepo (var ids : ItemDatasource){

    suspend fun insert(name:String, image: String, price: Int, count: Int) = ids.insert(name,image,price,count)

    suspend fun delete (id:Int) = ids.delete(id)

    suspend fun loaditems() : List<CartModel> = ids.loaditems()

}