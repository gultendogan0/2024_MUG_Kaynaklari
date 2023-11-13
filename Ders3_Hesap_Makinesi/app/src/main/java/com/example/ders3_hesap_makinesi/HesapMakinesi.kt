package com.example.ders3_hesap_makinesi

abstract class HesapMakinesi : HesapMakinesiIslemleri {
    fun modAlma(sayi1: Double, sayi2: Double): Double {
        if (sayi2 != 0.0) {
            return sayi1 % sayi2
        } else {
            throw IllegalArgumentException("Sıfıra bölme hatası")
        }
    }

}