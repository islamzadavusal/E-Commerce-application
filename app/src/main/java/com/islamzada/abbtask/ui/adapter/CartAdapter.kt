package com.islamzada.abbtask.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.islamzada.abbtask.data.model.CartModel
import com.islamzada.abbtask.databinding.RvCartBinding
import com.islamzada.abbtask.ui.viewmodel.CartViewModel

class CartAdapter (var mContext: Context, var itemList: List<CartModel>, var  viewModel: CartViewModel)

    : RecyclerView.Adapter<CartAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var binding: RvCartBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = RvCartBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val item = itemList.get(position)
        val b = holder.binding

        item.let {
            b.cartName.text = item.name
            b.CartPrice.text = "Rs. ${item.price}"
            b.CartCount.text = "Qty: ${item.count}"
            Glide.with(mContext).load(it.image).into(b.imageViewCart)
        }

        b.imageViewDelete.setOnClickListener {
            val builder = AlertDialog.Builder(mContext)
            builder.setMessage("Do you want to delete ${item.name} ?")
                .setCancelable(false)
                .setPositiveButton("YES") { dialog, id ->
                    viewModel.delete(item.id)
                }
                .setNegativeButton("NO") { dialog, id ->
                    dialog.dismiss()
                }
            val alert = builder.create()

            alert.window?.setBackgroundDrawable(ColorDrawable(Color.BLACK))

            alert.setOnShowListener {
                val messageView = alert.findViewById<TextView>(android.R.id.message)
                messageView.setTextColor(Color.parseColor("#FFFFFFFF"))

                val positiveButton = alert.getButton(AlertDialog.BUTTON_POSITIVE)
                positiveButton.setTextColor(Color.WHITE)

                val negativeButton = alert.getButton(AlertDialog.BUTTON_NEGATIVE)
                negativeButton.setTextColor(Color.WHITE)
            }

            alert.show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size

    }
}