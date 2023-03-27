package com.islamzada.abbtask.data.datasource

import com.islamzada.abbtask.data.model.CartModel
import com.islamzada.abbtask.data.model.ItemModel
import com.islamzada.abbtask.room.AppDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemDatasource (var idao : AppDao){

    suspend fun insert(name:String, image: String, price: Int, count: Int){
        val newItems = CartModel(0,name,image,price,count)
        idao.insert(newItems)
    }

    suspend fun delete(id:Int){
        val deleteItems = CartModel(id,"","",0,0)
        idao.delete(deleteItems)
    }

    suspend fun loaditems() : List <CartModel> =
        withContext(Dispatchers.IO){
            idao.loadItems()

        }
}