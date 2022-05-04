package com.example.ejercicioapinewsproto.repository.interactor

import com.example.ejercicioapinewsproto.repository.retrofit.noticias.Noticias
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.NoticiasAPIService
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.RestEngine
import retrofit2.Call

class NoticiasInteractor {

    fun traerNoticias(languages: String): Noticias?{
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
        val n: Noticias? = resultado.execute().body()

        return n
    }
}

/*fun keywordSearch(categorias: String): Noticias?{
    val llamada: NoticiasAPIService =
        RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
    val resultado: Call<Noticias> = llamada.filtrarBusqueda(category)
    val c: Noticias? = resultado.execute().body()

    return c*/