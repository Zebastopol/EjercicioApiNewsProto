package com.example.ejercicioapinewsproto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicioapinewsproto.repository.interactor.NoticiasInteractor
import com.example.ejercicioapinewsproto.repository.retrofit.noticias.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    val interactor = NoticiasInteractor()


    fun onBtnBuscarNoticias(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerNoticias("es"))

        }
    }



}
