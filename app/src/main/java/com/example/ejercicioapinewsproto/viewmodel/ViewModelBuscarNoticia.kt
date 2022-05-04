package com.example.ejercicioapinewsproto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicioapinewsproto.repository.interactor.BusquedaInteractor
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ViewModelBuscarNoticia: ViewModel() {

    val resultadoBusqueda: MutableLiveData<Noticias> = MutableLiveData()
    val interactorBusqueda = BusquedaInteractor()

    fun onBusqueda(){
        CoroutineScope(Dispatchers.IO).launch {

        }
    }
}