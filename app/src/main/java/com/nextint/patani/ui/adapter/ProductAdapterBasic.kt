package com.nextint.patani.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nextint.patani.core.local.AlmostPanenProduct
import com.nextint.patani.databinding.CardProductBinding

class ProductAdapterBasic<T>(private val typeProduct : ArrayList<T>,
                             private val action: ((T) -> Unit)) : RecyclerView.Adapter<ProductAdapterBasic<T>.ViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return ViewHolder1(CardProductBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.bind(typeProduct[position], action)
    }

    override fun getItemCount(): Int {
        return typeProduct.size
    }

    inner class ViewHolder1(private val binding: CardProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (typeProduct: T, action : ((T) -> Unit)){
            var title : String? = ""
            var price : String? = ""
            var waktuPanen : String? = ""
            var desc : String? = ""
            var image : String? = ""
            var  location : String? =""

            when(typeProduct) {
                is AlmostPanenProduct -> {
                    with(typeProduct){
                        title = this.title
                        price = this.price
                        waktuPanen = this.waktuPanen
                        desc = this.desc
                        image = this.image
                        location = this.location
                    }
                }

            }
            binding.apply {
                prouctTitle.text = title
                Glide.with(itemView.context)
                        .load(image)
                        .fitCenter()
                        .into(productImg)
                productPrice.text = price
                supplier.text = location
            }
            itemView.setOnClickListener { action(typeProduct) }
        }
    }
}