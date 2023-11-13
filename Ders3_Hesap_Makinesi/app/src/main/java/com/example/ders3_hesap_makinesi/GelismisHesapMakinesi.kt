package com.example.ders3_hesap_makinesi

class GelismisHesapMakinesi : HesapMakinesi() {
    override fun toplama(sayi1: Double, sayi2: Double): Double {
        return sayi1 + sayi2
    }

    override fun cikarma(sayi1: Double, sayi2: Double): Double {
        return sayi1 - sayi2
    }

    override fun carpma(sayi1: Double, sayi2: Double): Double {
        return sayi1 * sayi2
    }

    override fun bolme(sayi1: Double, sayi2: Double): Double {
        if (sayi2 != 0.0) {
            return sayi1 / sayi2
        } else {
            throw IllegalArgumentException("Sıfıra bölme hatası")
        }
    }
}