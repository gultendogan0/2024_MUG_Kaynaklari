package com.example.ders7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val myDatabase = this.openOrCreateDatabase("Ogrenciler",Context.MODE_PRIVATE,null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS ogr (id INTEGER PRIMARY KEY, name VARCHAR, age INT)")

            /*
            myDatabase.execSQL("INSERT INTO ogr (name,age) VALUES ('Ayse',20)")
            myDatabase.execSQL("INSERT INTO ogr (name,age) VALUES ('Ali',19)")
            myDatabase.execSQL("INSERT INTO ogr (name,age) VALUES ('Veli',21)")
             */

            //myDatabase.execSQL("UPDATE ogr SET age = 22 WHERE id = 2 ")

            myDatabase.execSQL("DELETE FROM ogr WHERE id = 1 ")

            val cursor = myDatabase.rawQuery("SELECT * FROM ogr ",null)

            val name = cursor.getColumnIndex("name")
            val age = cursor.getColumnIndex("age")
            val id = cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                println("Name: " + cursor.getString(name))
                println("Age: " + cursor.getString(age))
                println("Id: " + cursor.getString(id))
            }

            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
