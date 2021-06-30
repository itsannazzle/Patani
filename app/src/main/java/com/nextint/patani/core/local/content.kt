package com.nextint.patani.core.local

import com.nextint.patani.R

object content {
    private val kategori = arrayOf(
            "Wortel",
            "Kol",
            "Timun",
            "Terong",
            "Sawi",
            "Salada"
    )

    private val idProduct = arrayOf(
        "id Product 1",
        "id Product 2",
        "id Product 3",
        "id Product 4",
        "id Product 5",
        "id Product 6",
        "id Product 7",
        "id Product 8"
    )

    private val idKategori = arrayOf(
        "id kategori 1",
        "id kategori 2",
        "id kategori 3",
        "id kategori 4",
        "id kategori 5",
        "id kategori 6",
        "id kategori 7",
        "id kategori 8"
    )
    private val title = arrayOf(
            "Product 1",
            "Product 2",
            "Product 3",
            "Product 4",
            "Product 5",
            "Product 6",
            "Product 7",
            "Product 8"
    )

    private val price = arrayOf(
            "Rp.30.000",
            "Rp.90.000",
            "Rp.70.000",
            "RP.92.000",
            "Rp.130.000",
            "Rp.10.000",
            "Rp.30.000",
            "RP.72.000",
    )

    private val waktuPanen = arrayOf(
            "2 minggu",
            "3 minggu",
            "Besok",
            "Hari ini",
            "1 minggu",
            "1 minggu",
            "Lusa",
            "Hari ini",
    )

    private val desc = Array(title.size){
        i -> R.string.lorem.toString()
    }

    val product : ArrayList<DataProduct>
    get()  {
        val list = arrayListOf<DataProduct>()
        for (i in idProduct.indices){
            val j = DataProduct()
            j.title = this.title[i]
            j.price = this.price[i]
            j.waktuPanen = this.waktuPanen[i]
            j.desc = this.desc[i]
            list.add(j)
        }
        return list
    }
}