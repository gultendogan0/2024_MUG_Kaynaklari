package com.example.ders3

class Dikdortgen(val uzunluk: Double, val genislik: Double) : Sekil() {
    override fun alanHesapla(): Double {
        return uzunluk * genislik
    }
}

