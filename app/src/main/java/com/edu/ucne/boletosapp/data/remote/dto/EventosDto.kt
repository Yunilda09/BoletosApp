package com.edu.ucne.boletosapp.data.remote.dto

data class EventosDto(
    val eventoId: Int = 0,
    val nombreEvento: String = "",
    val descripcion: String = "",
    val fecha: String = "",
    val ubicacion: String = ""

)
/*
data class Evento(
    val Id: Int,
    val boletoId: Int,
    val nombreEvento: String,
    val fecha: String,
    val ubicacion: String
)*/
