package com.nextint.patani.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nextint.patani.R
import com.nextint.patani.core.local.KategoriProduct
import com.nextint.patani.databinding.CatergorySquareBinding

class KategoriAdapter(private val kategori : ArrayList<KategoriProduct>) : RecyclerView.Adapter<KategoriAdapter.ViewHolderKategory>() {
    inner class ViewHolderKategory(private val binding: CatergorySquareBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(kategori : KategoriProduct){
            with(binding){
                kategori.image.let { catehoryImage.setImageResource(it) }
                categoryTitle.text = kategori.title
                when {
                     kategori.type == "Sayur" -> cardCaetgory.setCardBackgroundColor(ContextCompat.getColor(itemView.context,R.color.accnet_green))
                    kategori.type == "Buah" -> cardCaetgory.setCardBackgroundColor(ContextCompat.getColor(itemView.context,R.color.accent_orange))
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderKategory {
        val binding = CatergorySquareBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderKategory(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderKategory, position: Int) {
        val kategori = kategori[position]
        holder.bind(kategori)
    }

    override fun getItemCount(): Int {
        return kategori.size
    }
}