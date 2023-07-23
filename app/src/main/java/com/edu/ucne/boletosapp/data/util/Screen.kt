package com.edu.ucne.boletosapp.data.util

sealed class Screen(val route: String, val title: String){
    object  Inicio : Screen("home","Inicio")

    object  EventoScreen : Screen("EventoScreen", "Evento")

    object EventoListScreen : Screen("EventoListScreen", "EventoListScreen")
    object  BoletosScreen : Screen("BoletoScreen", "Boleto")

    object  CompraScreen : Screen("CompraScreen", "Compra")
}
