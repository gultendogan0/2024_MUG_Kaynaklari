package com.example.ders5_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders5_intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val intent = Intent(applicationContext, DetailActivity::class.java)

            val bolum = binding.bolumEditText.text.toString()
            val okulNo = binding.okulNoEditText.text.toString().toInt()

            intent.putExtra("bolum",bolum)
            intent.putExtra("okulNo",okulNo)

            startActivity(intent)
        }
    }
}