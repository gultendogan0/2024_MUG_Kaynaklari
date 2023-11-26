package com.example.ders6_yemek_listesi

import java.io.Serializable

class Yemek(
    val yemekAdi:String,
    val yemekKategori:String,
    val yemekPuani:String,
    val yemekTarifi:String,
    val yemekResmi:Int) : Serializable {

}