package com.example.shoestore.viewmodel

import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    //this is private only for viewModel :
    private var _shoeDetail = MutableLiveData<List<Shoe>>()

    //this for reading in any destination : so i use (LiveData)
    val shoeDetail : LiveData<List<Shoe>> = _shoeDetail

    //Initialize:
    init {
        _shoeDetail.value = mutableListOf()
    }

    //fun for addShoe details to use it in (ShoeDetail Fragment):
    fun addShoe(newShoe: Shoe){
        _shoeDetail.value = _shoeDetail.value?.toMutableList()?.apply {
            add(newShoe)
        }
    }
}