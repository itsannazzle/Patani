package com.nextint.patani.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nextint.patani.databinding.PaymentMethodBinding

class PaymentAdapter(private val keranjang : ArrayList<String>) : RecyclerView.Adapter<PaymentAdapter.ViewHolderKategory>() {
    inner class ViewHolderKategory(private val binding: PaymentMethodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(imgUrl : String){
            with(binding){
                Glide.with(itemView.context)
                    .load(imgUrl)
                    .fitCenter()
                    .into(imageView3)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderKategory {
        val binding = PaymentMethodBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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