package com.nextint.patani.core.local

data class AlmostPanenProduct(
        var id : String = "",
        var title : String = "",
        var price : String = "",
        var waktuPanen : String = "",
        var desc : String = "",
        var image: String = "",
        var location :String = ""
)

data class KategoriProduct(
        var id : String ="",
        var title : String = "",
        var image : Int = 0,
        var type :String = ""
)
