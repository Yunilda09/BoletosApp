package com.edu.ucne.boletosapp.data.remote

data class BoletosDto(
    val BoletoId: Int = 0,
    val EventoId: Int = 0,
    val SeccionId: Int = 0,
)

data class Boletos(
    val id: Int,
    val EventoId: Int,
    val SeccionId: Int
)