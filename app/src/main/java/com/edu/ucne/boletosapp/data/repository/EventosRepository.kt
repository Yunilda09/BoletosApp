package com.edu.ucne.boletosapp.data.repository

import com.edu.ucne.boletosapp.data.remote.dto.EventosDto
import com.edu.ucne.boletosapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface EventosRepository {
    fun getEvento(id: Int): Flow<Resource<List<EventosDto>>>
    fun getEventobyId(id: Int): Flow<Resource<EventosDto>>
    //suspend fun postEvento(id: Int, eventosDto: EventosDto): EventosDto
suspend fun  putEvento(id: Int, eventosDto: EventosDto)
}