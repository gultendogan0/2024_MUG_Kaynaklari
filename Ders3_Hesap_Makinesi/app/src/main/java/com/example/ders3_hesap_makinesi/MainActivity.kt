package com.example.ders3_hesap_makinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders3_hesap_makinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var firstNumberStr: String
    private lateinit var secondNumberStr: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val hesapMakinesi = GelismisHesapMakinesi()

        binding.addButton.setOnClickListener {
            updateNumbers(binding)
            var sonuc = ""
            if (firstNumberStr.isNotEmpty() && secondNumberStr.isNotEmpty()) {
                sonuc = hesapMakinesi.toplama(firstNumberStr.toDouble(), secondNumberStr.toDouble()).toString()
                binding.sonucTextView.text = "Sonuç: $sonuc"
            } else {
                binding.sonucTextView.text = "Lütfen sayıları girin !"
            }
        }

        binding.subtractButton.setOnClickListener {
            updateNumbers(binding)
            var sonuc = ""
            if (firstNumberStr.isNotEmpty() && secondNumberStr.isNotEmpty()) {
                sonuc = hesapMakinesi.cikarma(firstNumberStr.toDouble(), secondNumberStr.toDouble()).toString()
                binding.sonucTextView.text = "Sonuç: $sonuc"
            } else {
                binding.sonucTextView.text = "Lütfen sayıları girin !"
            }
        }

        binding.multiplyButton.setOnClickListener {
            updateNumbers(binding)
            var sonuc = ""
            if (firstNumberStr.isNotEmpty() && secondNumberStr.isNotEmpty()) {
                sonuc = hesapMakinesi.carpma(firstNumberStr.toDouble(), secondNumberStr.toDouble()).toString()
                binding.sonucTextView.text = "Sonuç: $sonuc"
            } else {
                binding.sonucTextView.text = "Lütfen sayıları girin !"
            }
        }

        binding.divideButton.setOnClickListener {
            updateNumbers(binding)
            var sonuc = ""
            if (firstNumberStr.isNotEmpty() && secondNumberStr.isNotEmpty()) {
                if (secondNumberStr != "0"){
                    sonuc = hesapMakinesi.bolme(firstNumberStr.toDouble(), secondNumberStr.toDouble()).toString()
                    binding.sonucTextView.text = "Sonuç: $sonuc"
                }else{
                    binding.sonucTextView.text = "Lütfen sıfır girmeyin !"
                }

            } else {
                binding.sonucTextView.text = "Lütfen sayıları girin !"
            }
        }

        binding.modeButton.setOnClickListener {
            updateNumbers(binding)
            var sonuc = ""
            if (firstNumberStr.isNotEmpty() && secondNumberStr.isNotEmpty()) {
                if (secondNumberStr != "0"){
                    sonuc = hesapMakinesi.modAlma(firstNumberStr.toDouble(), secondNumberStr.toDouble()).toString()
                    binding.sonucTextView.text = "Sonuç: $sonuc"
                }else{
                    binding.sonucTextView.text = "Lütfen sıfır girmeyin !"
                }

            } else {
                binding.sonucTextView.text = "Lütfen sayıları girin !"
            }
        }

        binding.cleanButton.setOnClickListener {
            binding.firstNumberEditText.text.clear()
            binding.secondNumberEditText.text.clear()
            binding.sonucTextView.text = ""
        }
    }

    private fun updateNumbers(binding: ActivityMainBinding) {
        firstNumberStr = binding.firstNumberEditText.text.toString()
        secondNumberStr = binding.secondNumberEditText.text.toString()
    }
}