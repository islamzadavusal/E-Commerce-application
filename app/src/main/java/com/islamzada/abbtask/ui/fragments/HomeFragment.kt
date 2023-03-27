package com.islamzada.abbtask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.islamzada.abbtask.databinding.FragmentHomeBinding
import com.islamzada.abbtask.ui.adapter.ItemAdapter
import com.islamzada.abbtask.util.ItemList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = ItemList.itemList

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvHome.layoutManager = layoutManager

        val adapter = ItemAdapter(requireContext(), itemList)
        binding.rvHome.adapter = adapter

        adapter.onClick = {
            val action = HomeFragmentDirections.toDetails(it)
            findNavController().navigate(action)

        }
    }
}