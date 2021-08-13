package com.nextint.patani.core.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlmostPanenProduct(
        var id : Int = 0,
        var title : String = "",
        var price : String = "",
        var waktuPanen : String = "",
        var desc : String = "",
        var image: String = "",
        var location :String = ""
) : Parcelable

@Parcelize
data class KategoriProduct(
        var id : Int = 0,
        var title : String = "",
        var image : Int = 0,
        var type :String = ""
) : Parcelable

data class Keranjang(
        var title : String,
        var satuan : String,
        var qty : Int = 0,
        var totalPrice : Int = 0,
        var image : String
)
