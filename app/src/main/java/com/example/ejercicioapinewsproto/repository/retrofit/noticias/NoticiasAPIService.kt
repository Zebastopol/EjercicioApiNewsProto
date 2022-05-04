package com.example.ejercicioapinewsproto.repository.retrofit.noticias

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticiasAPIService {

    @GET("news?access_key=1f58aafe8ba2f5588194d50559e36ed0")

    fun obtenerNoticias(@Query("languages") languajes: String): Call<Noticias>
}