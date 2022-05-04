package com.example.ejercicioapinewsproto.repository.retrofit.usuarios

class Usuario : ArrayList<UsuarioItem>()

data class UsuarioItem(
    val nombre: String,
    val contrasena: String,
    val correo: String,
    val numero: String
)