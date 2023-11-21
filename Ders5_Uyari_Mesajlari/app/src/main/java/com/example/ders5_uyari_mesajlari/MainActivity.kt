package com.example.ders5_uyari_mesajlari

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ders5_uyari_mesajlari.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Başlık")
            alertDialogBuilder.setMessage("Bu bir Alert Dialog örneğidir.")

            alertDialogBuilder.setPositiveButton("Tamam") { dialog: DialogInterface, which: Int ->
                Toast.makeText(this,"İşlem onaylandı.",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            alertDialogBuilder.setNegativeButton("İptal") { dialog: DialogInterface, which: Int ->
                Toast.makeText(this,"İşlem iptal edildi.",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

}
