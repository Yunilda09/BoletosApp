package com.edu.ucne.boletosapp.data.repository

import com.edu.ucne.boletosapp.data.remote.dto.BoletosDto
import com.edu.ucne.boletosapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface BoletosRepository {
    fun getBoletos(id: Int): Flow<Resource<List<BoletosDto>>>

    fun getBoletosById(id: Int): Flow<Resource<BoletosDto>>

    suspend fun putBoleto(id: Int, boletosDto: BoletosDto)

}