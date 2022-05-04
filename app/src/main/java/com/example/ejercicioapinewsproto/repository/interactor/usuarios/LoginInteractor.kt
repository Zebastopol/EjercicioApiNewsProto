package com.example.ejercicioapinewsproto.repository.interactor.usuarios

import android.widget.Toast
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.RestEngine
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.Usuario
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioAPIService
import retrofit2.Call

class LoginInteractor {

    fun validarUsuario(usuario: String, pass: String): Usuario? {
        val llamada   : UsuarioAPIService =
            RestEngine.getRestEngine().create(UsuarioAPIService::class.java)
        val resultado : Call<Usuario> = llamada.devolverUsuario("bd.json")
        val u: Usuario? = resultado.execute().body()

        for (i in u!!){
            if(i.nombre == usuario && i.contrasena == pass){
                return u
            }
        }
        return null
    }

}