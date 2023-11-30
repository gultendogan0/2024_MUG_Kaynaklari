package com.example.ders7_seyehat_defteri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ders7_seyehat_defteri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var cityList: ArrayList<City>
    private lateinit var binding: ActivityMainBinding
    private lateinit var cityAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cityList = ArrayList()

        cityAdapter = CityAdapter(cityList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = cityAdapter

        try {
            val database = this.openOrCreateDatabase("City", MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT * FROM city",null)
            val cityName = cursor.getColumnIndex("cityname")
            val id = cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                val name = cursor.getString(cityName)
                val id = cursor.getInt(id)
                val pokemon = City(name, id)
                cityList.add(pokemon)
            }

            cityAdapter.notifyDataSetChanged()

            cursor.close()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.city_manu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add_city){
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("info","new")
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}