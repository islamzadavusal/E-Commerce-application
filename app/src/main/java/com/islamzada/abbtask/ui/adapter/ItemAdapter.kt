package com.islamzada.abbtask.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.islamzada.abbtask.data.model.ItemModel
import com.islamzada.abbtask.databinding.RvItemBinding

class ItemAdapter(var mContext: Context, var list: MutableList<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    var onClick: ( (ItemModel) -> Unit)? = null
    inner class ItemHolder(var binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val view = holder.binding
        val item = list[position]

        view.textViewName.text = item.name
        view.textViewPrice.text = "Rs. ${item.price}"
        Glide.with(mContext).load(item.image).into(view.imageViewPhoto)

        holder.itemView.setOnClickListener {
            onClick?.invoke(item)

        }
    }
}