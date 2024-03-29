package com.example.ejercicioapinewsproto.repository.retrofit.usuarios

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsuarioAPIService {

    @GET("{json}")
    fun devolverUsuario(@Path("json") json: String): Call<Usuario>

    @PUT("bd/{item}.json")
    fun registrarUsuario(@Path("item") item: Int, @Body usuario: UsuarioItem): Call<UsuarioItem>


}