package com.example.ders2_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders2_xml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val ogrenciListesi = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.ekleButton.setOnClickListener {
            var ad_soyad = binding.adSoyadEditText.text.toString()
            var ogrenci_no = binding.ogrenciNoEditText.text.toString()
            ogrenciEkle(ad_soyad, ogrenci_no)

            val ogrenciListesiText = binding.ogrenciListesiTextView
            ogrenciListesiText.text = ""

            for (ogrenci in ogrenciListesi) {
                ogrenciListesiText.append("$ogrenci\n")
            }

            binding.adSoyadEditText.text.clear()
            binding.ogrenciNoEditText.text.clear()
        }

    }

    fun ogrenciEkle(adSoyad: String, ogrenciNo: String) {
        val yeniOgrenci = "$adSoyad - $ogrenciNo"
        ogrenciListesi.add(yeniOgrenci)
    }
}