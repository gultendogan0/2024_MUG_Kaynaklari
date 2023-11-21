package com.example.ders5_sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders5_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var sharedPreferences = this.getSharedPreferences("com.example.ders5_sharedpreferences",Context.MODE_PRIVATE)

        val ageFromSharedPreferences = sharedPreferences.getString("Age","")
        binding.yasTextView.text = "GİRİLEN YAŞ: $ageFromSharedPreferences"

        binding.kaydetButton.setOnClickListener {
            val age = binding.yasEditText.text.toString()
            sharedPreferences.edit().putString("Age",age).apply()
            binding.yasTextView.text = "GİRİLEN YAŞ: $age"
        }

        binding.silButton.setOnClickListener {
            sharedPreferences.edit().remove("Age").apply()
            binding.yasTextView.text = "GİRİLEN YAŞ: "
        }

    }

}