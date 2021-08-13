package com.nextint.patani.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailProdukViewModel : ViewModel() {
    private var _qty = MutableLiveData<Int>()
    val qty : LiveData<Int> = _qty
    init {
        _qty.value = 0
    }

    fun qtyIncrement()  {
        _qty.value = _qty.value?.plus(1)

    }

    fun qtyDecrement()  {
        _qty.value = _qty.value?.minus(1)
    }

}