package com.islamzada.abbtask.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.islamzada.abbtask.data.repo.ItemRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(var irepo: ItemRepo): ViewModel() {

    fun insert(name:String, image: String,  price: Int, count: Int){
        CoroutineScope(Dispatchers.Main).launch {
            irepo.insert(name, image, price, count)

        }
    }
}