package com.nextint.patani.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.nextint.patani.core.local.AlmostPanenProduct
import com.nextint.patani.core.local.KategoriProduct
import java.lang.IllegalArgumentException

class DiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return when (oldItem) {
            is AlmostPanenProduct -> oldItem.id == (newItem as AlmostPanenProduct).id
            is KategoriProduct -> oldItem.id == (newItem as KategoriProduct).id
            else -> throw IllegalArgumentException("Unknown Entity")
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return when(oldItem){
            is AlmostPanenProduct -> oldItem == newItem as AlmostPanenProduct
            is KategoriProduct -> oldItem == newItem as KategoriProduct
            else -> throw IllegalArgumentException("Unknown Entity")
        }
    }
}