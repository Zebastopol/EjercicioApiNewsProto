package com.example.ejercicioapinewsproto.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejercicioapinewsproto.databinding.ActivityLoginBinding
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.RestEngine
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.Usuario
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioAPIService
import com.example.ejercicioapinewsproto.viewmodel.ViewModelLogin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var logViewModel: ViewModelLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logViewModel = ViewModelProvider(this).get(ViewModelLogin::class.java)
        observar()

        binding.btnRegistro.setOnClickListener{
            val intent = Intent(applicationContext, RegistroActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            binding.barraProgreso.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                var usua = binding.txtNombreUsuario.text.toString()
                var pass = binding.txtPass.text.toString()
                logViewModel.onBtnLogin(usua,pass)

            }

        }

    }

    private fun observar() {
        logViewModel.usuarios.observe(this, Observer{
        binding.barraProgreso.visibility = View.GONE
            if(logViewModel.usuarios != null){
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "Usuario no registrado", Toast.LENGTH_SHORT).show()
            }
        })

    }
}



