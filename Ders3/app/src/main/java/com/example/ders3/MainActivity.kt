package com.example.ders3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val ogrenci = Ogrenci("Ayse",21)
        ogrenci.selamVer()

        var isim : String? = null
        println("İsim: $isim")

        var yas : Int? = null
        println(yas ?: 0)

        if(yas == null){
            println("Bu değer null !")
        }else{
            println("Sonuç: $yas")
        }

        val isci = Isci("ahmet",30,"A12")


        val resultInt = add(3, 5) // Int tipindeki fonksiyon çağrılır.
        val resultDouble = add(3.5, 2.5) // Double tipindeki fonksiyon çağrılır.

        println("Int Result: $resultInt")
        println("Double Result: $resultDouble")

         */

        val circle: Shape = Circle()
        val square: Shape = Square()

        circle.draw() // Çalışma zamanında Circle sınıfının draw metodu çağrılır.
        square.draw() // Çalışma zamanında Square sınıfının draw metodu çağrılır.
    }

    fun add(a:Int, b:Int):Int {
        return a+b
    }

    fun add(a:Double, b:Double):Double{
        return a+b
    }
}