package com.nextint.patani.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nextint.patani.core.local.Keranjang
import com.nextint.patani.databinding.CardCartBinding

class KeranjangAdapter(private val keranjang : ArrayList<Keranjang>) : RecyclerView.Adapter<KeranjangAdapter.ViewHolderKategory>() {
    inner class ViewHolderKategory(private val binding: CardCartBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(kategori : Keranjang){
            with(binding){
                kategori.image.let { Glide.with(itemView.context)
                    .load(it)
                    .into(cardImage)}
                textView.text = kategori.title
                jumlahbeli.text = kategori.satuan
                harga.text = kategori.qty.toString()
                totalHarga.text = kategori.totalPrice.toString()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderKategory {
        val binding = CardCartBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderKategory(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderKategory, position: Int) {
        val kategori = keranjang[position]
        holder.bind(kategori)
    }

    override fun getItemCount(): Int {
        return keranjang.size
    }
}