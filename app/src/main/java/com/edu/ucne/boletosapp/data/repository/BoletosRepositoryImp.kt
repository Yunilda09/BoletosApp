package com.edu.ucne.boletosapp.data.repository

import com.edu.ucne.boletosapp.data.remote.dto.BoletosDto
import com.edu.ucne.boletosapp.data.remote.EventoApi
import com.edu.ucne.boletosapp.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BoletosRepositoryImp @Inject constructor(
    private val api: EventoApi
) : BoletosRepository {
    override fun getBoletos(id: Int): Flow<Resource<List<BoletosDto>>> = flow {
        try {
            emit(Resource.Loading())

            val boleto = api.getBoletos()

            emit(Resource.Success(boleto))
        } catch (e: HttpException) {

            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar tu conexion a internet"))
        }

    }
    override suspend fun putBoleto(id: Int, boletosDto: BoletosDto) {
        api.putBoleto(id, boletosDto)
    }

    override fun getBoletosById(id: Int): Flow<Resource<BoletosDto>> = flow {
        try {
            emit(Resource.Loading())

            val boleto = api.getBoletosById(id)

            emit(Resource.Success(boleto))

        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar tu conexion a internet"))
        }
    }

}