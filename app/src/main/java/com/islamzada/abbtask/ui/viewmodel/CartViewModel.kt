package com.islamzada.abbtask.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.islamzada.abbtask.data.model.CartModel
import com.islamzada.abbtask.data.repo.ItemRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var irepo: ItemRepo) : ViewModel() {
    var itemsList = MutableLiveData<List<CartModel>>()

    init {
        loadItems()
    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            irepo.delete(id)
            loadItems()
        }
    }

    fun loadItems() {
        CoroutineScope(Dispatchers.Main).launch {
            itemsList.value = irepo.loaditems()

        }
    }
}