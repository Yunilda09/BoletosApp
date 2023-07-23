package com.edu.ucne.boletosapp.ui.boletos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.ucne.boletosapp.data.remote.dto.BoletosDto
import com.edu.ucne.boletosapp.data.repository.BoletosRepositoryImp
import com.edu.ucne.boletosapp.data.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BoletosListState(
    val isLoading: Boolean = false,
    val listBoletosDto: List<BoletosDto> = emptyList(),
    val error: String = ""
)
data class BoletosListUiState(
    val boletos: List<BoletosDto> = emptyList()
)

data class BoletosState(
    val isLoading: Boolean = false,
    val boletos: BoletosDto = BoletosDto(),
    val boletoCancelar: BoletosDto? = null,
    val eventos: String? = null,
    val error: String = ""
)

@HiltViewModel
class BoletosViewModel @Inject constructor(
    private val boletoResp: BoletosRepositoryImp,
): ViewModel(){
    var BoletoId by mutableStateOf(0)
    var EventoId by mutableStateOf(0)
    var Precio by mutableStateOf(0)

    private val citasListState = MutableStateFlow(BoletosListUiState())
    val listUiState = citasListState.asStateFlow()

   /* var uiStateEventos = MutableStateFlow(EventoListState())
        private set*/
   private var uiStateBoleto = MutableStateFlow(BoletosState())
       private set

    fun cancelarCita(id: Int) {
        boletoResp.getBoletosById(id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    uiStateBoleto.update { it.copy(isLoading = true) }
                }
                is Resource.Success -> {
                    uiStateBoleto.update {
                        it.copy(boletoCancelar = result.data, isLoading = false)
                    }

                }
                is Resource.Error -> {
                    uiStateBoleto.update {
                        it.copy(
                            error = result.message ?: "Error desconocido",
                            isLoading = false
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
        if (uiStateBoleto.value.boletoCancelar != null) {
            viewModelScope.launch {
                /*boletoResp.putBoleto(
                     id, boletoDto = BoletosDto(
                          citaId = uiStateCita.value.citaACancelar?.citaId ?: 0,
                         clienteId = uiStateCita.value.citaACancelar?.clienteId ?: 0,
                         servicioId = uiStateCita.value.citaACancelar?.servicioId ?: 0,
                         estadoId = 2,
                         nombre = uiStateCita.value.citaACancelar?.nombre ?: "",
                         apellido = uiStateCita.value.citaACancelar?.apellido ?: "",
                         fecha = uiStateCita.value.citaACancelar?.fecha ?: ""

                     )

                )*/
            }
        }
    }
}


