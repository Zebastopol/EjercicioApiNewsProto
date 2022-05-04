package com.example.ejercicioapinewsproto.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejercicioapinewsproto.R
import com.example.ejercicioapinewsproto.databinding.ActivityRegistroBinding
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.RestEngine
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.Usuario
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioAPIService
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioItem
import com.example.ejercicioapinewsproto.viewmodel.ViewModel
import com.example.ejercicioapinewsproto.viewmodel.ViewModelRegistro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var registroViewModel: ViewModelRegistro


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.progressBar2.visibility = View.VISIBLE
        registroViewModel = ViewModelProvider(this).get(ViewModelRegistro::class.java)
        observar()
        binding.btnRegistrar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                var user = UsuarioItem(
                    binding.txtNombre.text.toString(),
                    binding.txtPass2.text.toString(),
                    binding.txtCorreo.text.toString(),
                    binding.txtNumeroTelefono.text.toString())

                registroViewModel.onBtnValidarUsuarioRegistro(user)
            }
        }

    }

    private fun observar() {
        registroViewModel.usuarios.observe(this, Observer{
            if (registroViewModel.usuarios != null){
                val intent = Intent(applicationContext,Login::class.java)
                startActivity(intent)
                    Toast.makeText(applicationContext, "Usuario ha sido creado exitosamente!!",
                        Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Usuario ya existe", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

    /*    var usu = binding.txtNombre.text.toString()

        var aux2 = validarUsuario(usu)


        if (aux2 == 0) {
            val x: Int = async {
                cantidadRegistros()
            }.await()

            agregarUsuario(
                x, UsuarioItem(
                    binding.txtNombre.text.toString(),
                    binding.txtPass2.text.toString(),
                    binding.txtCorreo.text.toString(),
                    binding.txtNumeroTelefono.text.toString()
                )
            )
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(applicationContext, "No se pudo crear el usuario!", Toast.LENGTH_SHORT).show()
            //binding.progressBar2.visibility = View.GONE
        }
    }
}*/


/*private fun agregarUsuario(x: Int, usuarioItem: UsuarioItem) {
    CoroutineScope(Dispatchers.IO).launch {
        val llamada : UsuarioAPIService =
            RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado : Call<UsuarioItem> = llamada.registrarUsuario(x,usuarioItem)
        val u:UsuarioItem? = resultado.execute().body()


    }
}

private fun cantidadRegistros(): Int {
    val llamada: UsuarioAPIService = RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
    val resultado: Call<Usuario> = llamada.devolverUsuario("bd.json")
    val u: Usuario? = resultado.execute().body()
    return u!!.size
}

private fun validarUsuario(usuario: String) : Int{
    val llamada: UsuarioAPIService =
        RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
    val resultado : Call<Usuario> = llamada.devolverUsuario("bd.json")
    val u:Usuario? = resultado.execute().body()

    var aux = 0
    for (i in u!!){
        if(i.nombre == usuario){
            aux = 1
        }
        else{
            aux = 0
        }
    }
    return aux
}*/
