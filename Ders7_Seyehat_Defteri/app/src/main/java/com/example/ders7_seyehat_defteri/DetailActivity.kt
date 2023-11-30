package com.example.ders7_seyehat_defteri

import android.content.Intent
import android.content.pm.PackageManager
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ders7_seyehat_defteri.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    var selectedBitmap : Bitmap? = null
    private lateinit var database: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        registerLauncher()

        val intent = intent
        val info = intent.getStringExtra("info")

        if (info.equals("new")){
            binding.cityNameEditText.setText("")
            binding.dateEditText.setText("")
            binding.saveButton.visibility = View.VISIBLE
        }else{
            binding.saveButton.visibility = View.INVISIBLE
            val selectedId = intent.getIntExtra("id",1)

            database = this.openOrCreateDatabase("City", MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT * FROM city WHERE id = ?", arrayOf(selectedId.toString()))

            val cityName = cursor.getColumnIndex("cityname")
            val date = cursor.getColumnIndex("date")
            val image = cursor.getColumnIndex("image")

            while (cursor.moveToNext()){
                binding.cityNameEditText.setText(cursor.getString(cityName))
                binding.dateEditText.setText(cursor.getString(date))

                val imageByteArray = cursor.getBlob(image)
                val bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.size)
                binding.detailImageView.setImageBitmap(bitmap)
            }
            cursor.close()
        }

        binding.detailImageView.setOnClickListener {

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                //Android 33+ -> READ_MEDIA_IMAGES
                if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_MEDIA_IMAGES)){
                        Snackbar.make(binding.root,
                            "Permission needed for gallery",
                            Snackbar.LENGTH_INDEFINITE).setAction("Give Permission",
                            View.OnClickListener {
                                permissionLauncher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
                            }).show()
                    }else{
                        permissionLauncher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
                    }
                }else{
                    val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)
                }
            }else{
                //Android 32- -> READ_EXTERNAL_STORAGE
                if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                        Snackbar.make(binding.root,
                            "Permission needed for gallery",
                            Snackbar.LENGTH_INDEFINITE).setAction("Give Permission",
                            View.OnClickListener {
                                permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                            }).show()
                    }else{
                        permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    }
                }else{
                    val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)
                }
            }
        }

        binding.saveButton.setOnClickListener {
            val cityName = binding.cityNameEditText.text.toString()
            val date = binding.dateEditText.text.toString()

            val image = selectedBitmap

            try {
                val database = this.openOrCreateDatabase("City", MODE_PRIVATE,null)
                database.execSQL("CREATE TABLE IF NOT EXISTS city(id INTEGER PRIMARY KEY, cityname VARCHAR, date VARCHAR, image BLOB)")

                val sqlString = "INSERT INTO city (cityname, date, image) VALUES (?,?,?)"
                val statement = database.compileStatement(sqlString)

                statement.bindString(1, cityName)
                statement.bindString(2, date)

                image?.let {
                    val byteArrayOutputStream = ByteArrayOutputStream()
                    it.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
                    val imageByteArray = byteArrayOutputStream.toByteArray()
                    statement.bindBlob(3, imageByteArray)
                }
                statement.execute()

            }catch (e:Exception){
                e.printStackTrace()
            }

            val intent = Intent(this@DetailActivity,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    private fun registerLauncher(){
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val intentFromResult = result.data
                if(intentFromResult != null){
                    val imageData = intentFromResult.data
                    if(imageData != null){
                        try {
                            if(Build.VERSION.SDK_INT >= 28){
                                val source = ImageDecoder.createSource(this@DetailActivity.contentResolver,imageData)
                                selectedBitmap = ImageDecoder.decodeBitmap(source)
                                binding.detailImageView.setImageBitmap(selectedBitmap)
                            }else{
                                selectedBitmap = MediaStore.Images.Media.getBitmap(contentResolver,imageData)
                                binding.detailImageView.setImageBitmap(selectedBitmap)
                            }
                        }catch (e: Exception){
                            e.printStackTrace()
                        }
                    }
                }
            }
        }

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ result ->
            if(result){
                // İzin verildiyse
                val intentToGallery = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            }else{
                // İzin verilmediyse
                Toast.makeText(this@DetailActivity,"Permission needed!", Toast.LENGTH_LONG).show()
            }
        }
    }
}