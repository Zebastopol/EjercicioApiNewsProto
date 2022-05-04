package com.example.ejercicioapinewsproto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicioapinewsproto.repository.interactor.usuarios.LoginInteractor
import com.example.ejercicioapinewsproto.repository.retrofit.usuarios.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelLogin: ViewModel() {

    var usuarios: MutableLiveData<Usuario> = MutableLiveData()
    var inteUsuarios = LoginInteractor()

    fun onBtnLogin(nombre: String, contrasena: String){
        CoroutineScope(Dispatchers.IO).launch {
            usuarios.postValue(inteUsuarios.validarUsuario(nombre,contrasena))
        }
    }
}