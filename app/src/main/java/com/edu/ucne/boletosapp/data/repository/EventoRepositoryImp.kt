package com.edu.ucne.boletosapp.data.repository

import com.edu.ucne.boletosapp.data.remote.EventoApi
import com.edu.ucne.boletosapp.data.remote.dto.EventosDto
import com.edu.ucne.boletosapp.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class EventoRepositoryImp @Inject constructor(
    private val api: EventoApi
    ) : EventosRepository {

        override fun getEvento(id: Int): Flow<Resource<List<EventosDto>>> = flow {
            try {
                emit(Resource.Loading())

                val evento = api.getEvento()

                emit(Resource.Success(evento))
            } catch (e: HttpException) {

                emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: "Verificar tu conexion a internet"))
            }

        }

        override fun getEventobyId(id: Int): Flow<Resource<EventosDto>> = flow {
            try {
                emit(Resource.Loading())

                val evento = api.getEventoById(id)

                emit(Resource.Success(evento))

            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: "Verificar tu conexion a internet"))
            }
        }
    override suspend fun putEvento(id: Int, eventosDto: EventosDto) {
        api.putEvento(id, eventosDto)

    }


    }