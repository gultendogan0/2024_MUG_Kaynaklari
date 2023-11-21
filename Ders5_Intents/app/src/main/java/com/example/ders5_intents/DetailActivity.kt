package com.example.ders5_intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders5_intents.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent

        val bolum = intent.getStringExtra("bolum")
        val okulNo = intent.getIntExtra("okulNo",0)

        binding.bolumTextView.text = bolum
        binding.okulNoTextView.text = okulNo.toString()

    }
}