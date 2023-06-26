package com.edu.ucne.boletosapp.data.repository

import com.edu.ucne.boletosapp.data.remote.EventosDto
import com.edu.ucne.boletosapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface EventosRepository {
    fun getEventos(id: Int): Flow<Resource<List<EventosDto>>>

    fun getEventosById(id: Int): Flow<Resource<EventosDto>>

}