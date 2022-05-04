package com.example.ejercicioapinewsproto.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ejercicioapinewsproto.R
import com.example.ejercicioapinewsproto.databinding.ActivityDetalleNoticiaBinding
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.Data
import com.google.gson.Gson

class DetalleNoticia : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleNoticiaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleNoticiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.extras?.getString("data")
        val news: Data = Gson().fromJson(text, Data::class.java)
        
        binding.myNewsWebView.loadUrl(news.url)

        val shareButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.btnShare)
        shareButton.setOnClickListener {
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey, echale un vistazo a esta noticia "+news.url)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
        }
        /*binding.txtTituloDetail.text = news.title
        binding.txtNoticiaDetail.text = news.description*/
    }
}