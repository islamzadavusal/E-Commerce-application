package com.islamzada.abbtask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamzada.abbtask.R
import com.islamzada.abbtask.databinding.FragmentCartBinding
import com.islamzada.abbtask.ui.adapter.CartAdapter
import com.islamzada.abbtask.ui.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        binding.mycartFragment = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.itemsList.observe(viewLifecycleOwner){
            val adapter = CartAdapter(requireContext(),it,viewModel)
            binding.adapter = adapter

            var totalPrice = 0
            for (item in viewModel.itemsList.value ?: emptyList()) {
                totalPrice += item.price
            }

            binding.cartTotalPriceText.text = "Total Price: Rs. $totalPrice"

        }

        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    override fun onResume() {
        super.onResume()
        viewModel.loadItems()
    }
}