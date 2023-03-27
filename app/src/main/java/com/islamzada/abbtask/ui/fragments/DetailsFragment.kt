package com.islamzada.abbtask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.islamzada.abbtask.R
import com.islamzada.abbtask.data.model.CartModel
import com.islamzada.abbtask.databinding.FragmentDetailsBinding
import com.islamzada.abbtask.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.backScreenBackground.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toHomeBack)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: DetailsFragmentArgs by navArgs()
        val itemModel = data.itemModel
        binding.itemModel = itemModel
        binding.itemDetailsPrice.text = itemModel.price.toString()
        Glide.with(requireView()).load(itemModel.image).into(binding.itemImageView)

        binding.addToCartButton.setOnClickListener {

            val cartModel = CartModel(
                name = itemModel.name,
                image = itemModel.image,
                price = itemModel.price,
                count = 1
            )

            viewModel.insert(
                name = cartModel.name,
                image = cartModel.image,
                price = cartModel.price,
                count = cartModel.count
            )

            Snackbar.make(it, "Food has been added to your Cart", Snackbar.LENGTH_SHORT).show()

            Navigation.findNavController(it).navigate(R.id.toCart)
        }
    }
}