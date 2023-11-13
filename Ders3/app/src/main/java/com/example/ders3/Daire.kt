package com.example.ders3

class Daire(val yaricap: Double) : Sekil() {
    override fun alanHesapla(): Double {
        return 3.14 * yaricap * yaricap
    }
}

