package com.example.firebaseexample

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
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
import com.example.firebaseexample.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage
import java.io.ByteArrayOutputStream
import java.util.UUID

class DetailActivity : AppCompatActivity() {

    val db = Firebase.firestore
    private lateinit var binding: ActivityDetailBinding
    private lateinit var auth: FirebaseAuth
    var selectedBitmap : Bitmap? = null
    var selectedImage : Uri? = null
    val storage = Firebase.storage
    var downloadUrl : String? = null
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        registerLauncher()

        binding.shareButton.setOnClickListener {
            val sharedComment = binding.commentEditText.text.toString()
            val user = auth.currentUser!!.email.toString()
            val date = com.google.firebase.Timestamp.now()

            if (selectedImage != null){
                val reference = storage.reference
                val uuid = UUID.randomUUID()
                var imageName = "${uuid}.jpg"

                val imageReference = reference.child("images").child(imageName)

                imageReference.putFile(selectedImage!!).addOnSuccessListener { task ->
                    var uploadImageReference = reference.child("images").child(imageName)
                    uploadImageReference.downloadUrl.addOnSuccessListener { uri->
                        downloadUrl = uri.toString()
                        uploadDataToFirestore(sharedComment, user, date, downloadUrl)
                    }
                }.addOnFailureListener{ exception ->
                    Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }
        }

        binding.addImageButton.setOnClickListener {
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

    }

    fun uploadDataToFirestore(sharedComment: String, user: String, date: com.google.firebase.Timestamp, downloadUrl: String?) {
        val shareMap = hashMapOf<String, Any>()
        shareMap.put("sharedComment", sharedComment)
        shareMap.put("user", user)
        shareMap.put("date", date)

        // downloadUrl null değilse imageUrl ekleyelim
        downloadUrl?.let {
            shareMap.put("imageUrl", it)
        }

        db.collection("Shares").add(shareMap).addOnCompleteListener { task ->
            if (task.isSuccessful) finish()
        }.addOnFailureListener { exception ->
            Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
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
                                binding.imageView.setImageBitmap(selectedBitmap)
                                selectedImage = imageData  // Burada selectedImage'i güncelliyoruz
                            } else {
                                selectedBitmap = MediaStore.Images.Media.getBitmap(contentResolver,imageData)
                                binding.imageView.setImageBitmap(selectedBitmap)
                                selectedImage = imageData  // Burada selectedImage'i güncelliyoruz
                            }
                        } catch (e: Exception){
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


