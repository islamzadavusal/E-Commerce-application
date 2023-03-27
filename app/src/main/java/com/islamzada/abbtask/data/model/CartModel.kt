package com.islamzada.abbtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")

data class CartModel(

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id") var id: Int = 0,

    @ColumnInfo(name = "name") var name: String,

    @ColumnInfo(name = "image") var image:String,

    @ColumnInfo(name = "price") var price:Int,

    @ColumnInfo(name = "count") var count:Int ) :java.io.Serializable {

}