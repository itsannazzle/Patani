package com.nextint.patani.core.local

data class DataProduct(
        var idProduct : String? = "",
        var title : String? = "",
        var price : String? = "",
        var waktuPanen : String? = "",
        var desc : String? = ""
)

data class KaterogiProduct(
        var idKategori : String? ="",
        var kategori : String? = "",
)
