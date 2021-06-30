package com.nextint.patani.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.nextint.patani.core.local.DataProduct
import com.nextint.patani.core.local.KaterogiProduct
import java.lang.IllegalArgumentException

class DiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return when (oldItem) {
            is DataProduct -> oldItem.idProduct == (newItem as DataProduct).idProduct
            is KaterogiProduct -> oldItem.idKategori == (newItem as KaterogiProduct).idKategori
            else -> throw IllegalArgumentException("Unknown Entity")
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return when(oldItem){
            is DataProduct -> oldItem == newItem as DataProduct
            is KaterogiProduct -> oldItem == newItem as KaterogiProduct
            else -> throw IllegalArgumentException("Unknown Entity")
        }
    }
}