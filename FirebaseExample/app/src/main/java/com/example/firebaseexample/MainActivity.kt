package com.example.firebaseexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseexample.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null){
            val intent = Intent(this,ShareActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.signUpButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(applicationContext,"Kullanıcı Oluşturuldu.",Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if(!password.isNullOrEmpty() || !email.isNullOrEmpty()){
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val currentUser = auth.currentUser?.email.toString()
                        Toast.makeText(applicationContext, "Hoş geldin: ${currentUser}",Toast.LENGTH_LONG).show()

                        val intent = Intent(this,ShareActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,"Email ve password girin.",Toast.LENGTH_LONG).show()
            }
        }
    }
}