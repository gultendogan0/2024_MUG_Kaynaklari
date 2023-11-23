package com.example.ders5_basit_not_defteri

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ders5_basit_not_defteri.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var sharedPreferences = this.getSharedPreferences("com.example.ders5_basit_not_defteri_deneme", Context.MODE_PRIVATE)

        binding.addDetailButton.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Yeni Not")
            alertDialogBuilder.setMessage("Yeni bir not eklemeyi yada değiştirmeyi istiyor musunuz?")

            alertDialogBuilder.setPositiveButton("Evet") { dialog: DialogInterface, which: Int ->
                val baslik = binding.baslikEditText.text.toString()
                val aciklama = binding.aciklamaEditText.text.toString()

                sharedPreferences.edit().putString("Baslik",baslik).apply()
                sharedPreferences.edit().putString("Aciklama",aciklama).apply()

                finish()

                Toast.makeText(this,"İşlem onaylandı.",Toast.LENGTH_LONG).show()

                dialog.dismiss()
            }

            alertDialogBuilder.setNegativeButton("Hayır") { dialog: DialogInterface, which: Int ->
                Toast.makeText(this,"İşlem iptal edildi.",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}
