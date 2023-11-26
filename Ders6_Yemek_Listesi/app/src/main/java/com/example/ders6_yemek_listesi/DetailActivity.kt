package com.example.ders6_yemek_listesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders6_yemek_listesi.databinding.ActivityDetailBinding
import com.example.ders6_yemek_listesi.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val secilenYemek = intent.getSerializableExtra("YemekListesi") as Yemek
        binding.detailView.setImageResource(secilenYemek.yemekResmi)
        binding.detayBaslikText.text = secilenYemek.yemekAdi
        binding.detayTarifText.text = secilenYemek.yemekTarifi
    }
}