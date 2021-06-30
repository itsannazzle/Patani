package com.nextint.patani.core.local

import com.nextint.patani.R

object content {
    private val titleKategori = arrayOf(
            "Wortel",
            "Kol",
            "Tomat",
            "Terong",
            "Sawi",
            "Salada",
            "Strawberry",
            "Kentang"
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

    private val iconKategori = arrayOf(
            R.drawable.ic_wortel,
            R.drawable.ic_apple,
            R.drawable.ic_wortel,
            R.drawable.ic_apple,
            R.drawable.ic_wortel,
            R.drawable.ic_apple,
            R.drawable.ic_wortel,
            R.drawable.ic_apple,

    )
    private val tipeKategori = arrayOf(
        "Sayur",
        "Buah",
        "Sayur",
        "Buah",
        "Sayur",
        "Buah",
        "Sayur",
        "Buah",

        )
    private val titleProduct = arrayOf(
            "Kentang",
            "Ubi Ungu",
            "Kol",
            "Daun Bawang",
            "Tomat",
            "Cabai Merah",
            "Sawi Hijau",
            "Bawang Merah"
    )

    private val priceProduct = arrayOf(
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

    private val location = arrayOf(
            "Bogor",
            "Sukabumi",
            "Bandung",
            "Cianjur",
            "Sumedang",
            "Pekalongan",
            "Surabaya",
            "Tegal",
    )

    private val imageProduct = arrayOf(
            "https://t4.ftcdn.net/jpg/00/12/67/03/240_F_12670308_0T24c0uDIOIbiT6KpcFTFz8JrFXC88by.jpg",
            "https://as1.ftcdn.net/v2/jpg/00/36/08/52/1000_F_36085218_riPUMlbDix7hDx0ufcsDthozDEIgdCOK.jpg",
            "https://t3.ftcdn.net/jpg/02/07/28/92/240_F_207289269_dkOnzpd0q27I8GVR6FlooAJdj0bC98nd.jpg",
            "https://as2.ftcdn.net/v2/jpg/03/09/12/35/1000_F_309123582_Zk9rTTz7G0NzIUsUZjoybShXKyTfmC9C.jpg",
            "https://as2.ftcdn.net/v2/jpg/01/08/78/81/1000_F_108788189_SPrPScoLvMTqYKoooHQWUsGC873dcyku.jpg",
            "https://as2.ftcdn.net/v2/jpg/02/42/05/21/1000_F_242052156_erQ1Tz6iVqtKxDqkVBdh5BJ6raNY9DTd.jpg",
            "https://as2.ftcdn.net/v2/jpg/01/99/61/79/1000_F_199617959_sdb3e5aEHT1WDH3d9iUS7BoF2zlCL6X4.jpg",
            "https://as2.ftcdn.net/v2/jpg/01/23/54/55/1000_F_123545590_7gPiE9UI8HxUsnZU0vcoO3fiSnVKlaMj.jpg",
    )

    private val descProduct = Array(titleProduct.size){
        i -> R.string.lorem.toString()
    }

    val panenSebentarLagi : ArrayList<AlmostPanenProduct>
    get()  {
        val list = arrayListOf<AlmostPanenProduct>()
        for (i in idProduct.indices){
            val j = AlmostPanenProduct()
            j.title = titleProduct[i]
            j.price = priceProduct[i]
            j.waktuPanen = this.waktuPanen[i]
            j.desc = descProduct[i]
            j.image = imageProduct[i]
            j.location = this.location[i]
            list.add(j)
        }
        return list
    }

    val kategoriContent : ArrayList<KategoriProduct>
    get() {
        val list = arrayListOf<KategoriProduct>()
        for (i in idKategori.indices){
            val j = KategoriProduct()
            j.id = idKategori[i]
            j.image = iconKategori[i]
            j.title = titleKategori[i]
            j.type = tipeKategori[i]
            list.add(j)
        }
        return list
    }
}