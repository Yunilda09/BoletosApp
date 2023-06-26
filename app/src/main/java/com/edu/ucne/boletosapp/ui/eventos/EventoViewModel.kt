package com.edu.ucne.boletosapp.ui.eventos

import com.edu.ucne.boletosapp.data.remote.EventosDto


data class EventosListState(
    val isLoading: Boolean = false,
    val listEventoDto: List<EventosDto> = emptyList(),
    val error: String = ""
)
/*
data class EventosListUiState(
    val eventos: List<Evento> = emptyList()
)*/
data class BoletoUiState(
    val boletoId: Int = 0,
)
class EventosListScreen {
}
class EventoViewModel {
}