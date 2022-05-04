package com.example.ejercicioapinewsproto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicioapinewsproto.repository.interactor.usuarios.RegistroInteractor
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.Usuario
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.UsuarioItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModelRegistro: ViewModel() {

    var usuarios : MutableLiveData<Int> = MutableLiveData()
    var registroInteractor = RegistroInteractor()


    fun onBtnValidarUsuarioRegistro(usuarioItem: UsuarioItem){
        CoroutineScope(Dispatchers.IO).launch {
            var x: Usuario? = registroInteractor.validarUsuario(usuarioItem.nombre)

            if(x == null){
                //val cant = registroInteractor.cantidadRegistros()
                val aux: Int =
                    withContext(Dispatchers.Default) {
                        registroInteractor.cantidadRegistros()
                    }
                registroInteractor.agregarUsuario(aux, usuarioItem)
                usuarios.postValue(1)
            }else{
                usuarios.postValue(0)
            }
        }
    }

}