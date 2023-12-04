package com.example.firebaseexample

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaseexample.databinding.ActivityShareBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class ShareActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
    var shareList = ArrayList<Share>()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        getData()

        recyclerViewAdapter = RecyclerViewAdapter(shareList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = recyclerViewAdapter
    }

    fun getData(){
        db.collection("Shares").addSnapshotListener { value, error ->
            if (error != null){
                Toast.makeText(this,error.localizedMessage, Toast.LENGTH_LONG).show()
            }else{
                if (value != null && !value.isEmpty){
                    val documents = value.documents

                    shareList.clear()

                    for (document in documents){
                        val user = document.get("user") as String
                        val sharedComment = document.get("sharedComment") as String
                        val imageUrl = document.get("imageUrl") as String?

                        var getShare = Share(user,sharedComment,imageUrl)
                        shareList.add(getShare)
                    }

                    recyclerViewAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.log_out){
            auth.signOut()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }else if(item.itemId == R.id.share){
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}