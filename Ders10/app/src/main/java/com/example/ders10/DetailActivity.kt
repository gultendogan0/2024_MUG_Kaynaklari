package com.example.ders10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ders10.databinding.ActivityDetailBinding
import com.example.ders10.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val displayName = intent.getStringExtra("displayName")
        val description = intent.getStringExtra("description")
        val fullPortrait = intent.getStringExtra("fullPortrait")
        val role = intent.getStringExtra("role")

        binding.displayNameText.text = displayName
        binding.agentNameText.text = displayName
        binding.descriptionText.text = description
        binding.roleText.text = role

        Picasso.get().load(fullPortrait).into(binding.fullPortraitImage)
    }
}