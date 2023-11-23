package com.example.ders5_basit_not_defteri

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders5_basit_not_defteri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = Intent(applicationContext,DetailActivity::class.java)

        binding.addButton.setOnClickListener {
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = this.getSharedPreferences("com.example.ders5_basit_not_defteri_deneme", Context.MODE_PRIVATE)
        val baslik = sharedPreferences.getString("Baslik", "")
        val aciklama = sharedPreferences.getString("Aciklama", "")

        binding.baslikTextView.text = baslik
        binding.aciklamaTextView.text = aciklama
    }
}
