package com.example.ejercicioapinewsproto.repository.interactor.usuarios

import android.widget.Toast
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.RestEngine
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.Usuario
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioAPIService
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class RegistroInteractor {

    fun validarUsuario(usu: String): Usuario? {
        val llamada : UsuarioAPIService =
            RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado : Call<Usuario> = llamada.devolverUsuario("bd.json")
        val u: Usuario? = resultado.execute().body()

        for (i in u!!){
            if (i.nombre == usu){
                return u
            }
        }
        return null
    }

    fun agregarUsuario(x: Int, usuarioItem: UsuarioItem) {
            val llamada : UsuarioAPIService = RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
            val resultado : Call<UsuarioItem> = llamada.registrarUsuario(x,usuarioItem)
            val u: UsuarioItem? = resultado.execute().body()
    }

    fun cantidadRegistros(): Int {
        val llamada: UsuarioAPIService = RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado: Call<Usuario> = llamada.devolverUsuario("bd.json")
        val u: Usuario? = resultado.execute().body()
        return u!!.size
    }

}
