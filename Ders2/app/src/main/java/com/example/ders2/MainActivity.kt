package com.example.ders2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        println("Bu birinci satır")
        println("Bu ikinci satır")
         */

        /*
        var sayi = 5   // Değiştirilebilir değişken
        val isim = "Ahmet"  // Sabit değişken
        sayi = 6
        isim = "Ali"
         */

        /*
        var yas = 23
        val sonuc = yas*2 + 4
        println("Sonuç: ${sonuc}")
         */

        /*
        var count : Int
        //count = 10.5
        val num : Int = 5
        val number = 5
        println(number/2)
         */

        /*
        val pi = 3.14 // -> Double
        val e = 2.7182818284 // -> Double
        val eFloat = 2.7182818284f // -> Float
         */

        /*
        var name = "Jessie"

         */

        /*
        var name : String
        name = "Jessie"
         */

        /*
        val name = "James"
        val surname = "Hatfield"
        val fullname = name + surname
        println(fullname)
         */

        /*
        val kelime = "Merhaba"
        val harf = kelime[0]
        println(harf)
         */

        /*
        val kelime = " Merhaba "
        val uzunluk = kelime.length
        val buyukHarf = kelime.uppercase()
        val kucukHarf = kelime.lowercase()
        println("Uzunluk: $uzunluk, \n Büyük Harf: $buyukHarf, \n Küçük Harf: $kucukHarf")
         */

        /*
        val isStudent : Boolean = true
        val isTeacher : Boolean = false
         */

        /*
        val x = true
        val y = false
        val sonuc = x && y
        println(sonuc)
         */


        /*
        val sayi1 = 5
        val sayi2 = 10
        val esitMi = (sayi1 == sayi2)
        println(esitMi)
         */


        /*
        var number = 5
        var longNumber = number.toLong()
         */

        /*
        var input = "10"
        var inputInteger = input.toInt()
        println(inputInteger*2)
         */


        /*
        val sayilar = arrayOf(1, 2, 3, 4, 5)
        val isimler = arrayOf("Ahmet", "Mehmet", "Ayşe")
        println("Sayıların ilk elemanı ${sayilar[0]}")
        println("İsimlerin iilk elemanı ${isimler[0]}")
         */


        /*
        val sayilar: Array<Int> = arrayOf(1, 2, 3, 4, 5)
        val ilkSayi = sayilar[0]
        println("İlk Sayı: $ilkSayi")
        sayilar[1] = 10
        println("Değiştirilen Değer: ${sayilar[1]}")
        val diziBoyutu = sayilar.size
        println("Dizi Boyutu: $diziBoyutu")
         */

        /*
        val dizi: Array<Any> = arrayOf(1, "Ahmet", 3.14, true)
         */

        /*
        for (i in 1..10) {
            println("Değer: $i")
        }
         */

        /*
        val isimler = arrayOf("Ahmet", "Mehmet", "Ayşe")
        for (isim in isimler) {
            println("İsim: $isim")
        }
         */

        /*
        val matris = Array(2) { Array(3) { 0 } } // 2x3'lük matris -> tüm elemanlar sıfır ile dolduruldu.
        println(matris[0][0])
        matris[0][0] = 1
        println(matris[0][0])
        for (i in matris.indices) {
            for (j in matris[i].indices) {
                println("matris[$i][$j] = ${matris[i][j]}")
            }
        }
         */

        /*
        val sehirler = mutableListOf("Adana", "Maraş", "Çanakkale")
        println("Şehirler Listesi: $sehirler")
        sehirler.add("Osmaniye") // Listeye yeni bir şehir ekler
        println("Şehir Eklenen Liste: $sehirler")
        sehirler.remove("Maraş")   // Listeden bir şehiri çıkarır
        println("Şehir Çıkarılan Liste: $sehirler")
         */


        /*
        val gunler = listOf("Pazartesi", "Salı", "Çarşamba")
        //gunler.add("Perşembe")
        val gun = gunler[2]
        println("Gün: $gun")
         */

        /*
        val sabitSet = setOf("Elma", "Muz", "Portakal")
        val degistirilebilirSet = mutableSetOf("Kırmızı", "Yeşil", "Mavi")
         */

        /*
        val meyveler = setOf("Elma", "Muz", "Portakal")
        val varMi = meyveler.contains("Elma") // true
         */

        /*
        val kume1 = setOf(1, 2, 3)
        val kume2 = setOf(3, 4, 5)
        val kesisim = kume1.intersect(kume2) // [3]
        val birlesim = kume1.union(kume2) // [1, 2, 3, 4, 5]
         */

        /*
        val sehirler = mutableSetOf("İstanbul", "Ankara", "İzmir")
        sehirler.add("Antalya") // Set'e yeni bir şehir ekler
        sehirler.remove("Ankara") // Set'ten bir şehri çıkarır
         */

        /*
        val telefonRehberi = hashMapOf(
            "Ahmet" to "555-1234",
            "Mehmet" to "555-5678",
            "Ayşe" to "555-4321"
        )
        val ahmetinTelefonu = telefonRehberi["Ahmet"] // "555-1234"
        telefonRehberi["Ali"] = "555-9999" // Yeni bir kişi ekler
        telefonRehberi["Mehmet"] = "555-8765" // Mehmet'in telefon numarasını günceller
        telefonRehberi.remove("Ayşe") // Ayşe'yi rehberden çıkarır
         */

        /*
        val not = 75
        if (not >= 90) {
            println("A")
        } else if (not >= 80) {
            println("B")
        } else if (not >= 70) {
            println("C")
        } else {
            println("F")
        }
         */

        /*
        val not = 85
        when (not) {
            in 90..100 -> println("A")
            in 80..89 -> println("B")
            in 70..79 -> println("C")
            else -> println("F")
        }
         */

        /*
        val sonuc = toplama(5,12)
        println("Sonuc: $sonuc")
         */

    }

    /*
    fun toplama(a: Int, b: Int): Int {
        return a + b
    }
     */

}