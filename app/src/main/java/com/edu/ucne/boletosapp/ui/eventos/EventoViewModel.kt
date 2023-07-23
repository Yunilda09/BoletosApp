package com.edu.ucne.boletosapp.ui.eventos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.ucne.boletosapp.data.remote.dto.EventosDto
import com.edu.ucne.boletosapp.data.repository.EventosRepositoryImp
import com.edu.ucne.boletosapp.data.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



data class EventosState(
    val isLoading: Boolean = false,
    val evento: EventosDto? = null,
    val error: String = ""
)

data class EventoListState(
    val isLoading: Boolean = false,
    val evento: List<EventosDto> = emptyList(),
    val error: String = ""
)
@HiltViewModel
class EventoViewModel @Inject constructor(
    private val eventoRespo: EventosRepositoryImp,

): ViewModel() {

    var eventoId by mutableStateOf(0)
    var evento by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var nombreEvento by mutableStateOf("")
    var ubicacion by mutableStateOf("")
    var fecha by mutableStateOf("")
    var fechaError by mutableStateOf("Debe seleccionar una fecha")


    var uiStateEventos = MutableStateFlow(EventosState())
        private set

    var uiState = MutableStateFlow(EventoListState())
        private set


    fun setEvento(id:Int){
        eventoId = id

        eventoRespo.getEventobyId(eventoId).onEach { result ->
            when(result){
                is Resource.Loading ->{
                    uiStateEventos.update { it.copy(isLoading = true)}
                }
                is Resource.Success ->{
                    uiStateEventos.update {
                        it.copy(evento = result.data)
                    }
                    nombreEvento = uiStateEventos.value.evento!!.nombreEvento
                    descripcion = uiStateEventos.value.evento!!.descripcion
                    fecha = uiStateEventos.value.evento!!.fecha
                    ubicacion = uiStateEventos.value.evento!!.ubicacion
                }
                is Resource.Error -> {
                    uiStateEventos.update { it.copy(error = result.message ?: " Error desconocido") }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun putEvento(){
        viewModelScope.launch {
            eventoRespo.putEvento(eventoId, EventosDto(
                eventoId = eventoId,
                descripcion,
                uiStateEventos.value.evento!!.nombreEvento,
                ubicacion,uiStateEventos.value.evento!!.ubicacion,
               // evento,uiStateEventos.value.evento!!.fecha,
            )
            )
        }
    }
    init {
        eventoRespo.getEvento(id = eventoId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    uiState.update { it.copy(isLoading = true) }
                }
                is Resource.Success -> {
                    uiState.update {
                        it.copy(evento = result.data ?: emptyList())
                    }
                }
                is Resource.Error -> {
                    uiState.update { it.copy(error = result.message ?: "Error desconocido") }
                }
            }
        }.launchIn(viewModelScope)
    }

}
