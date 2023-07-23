package com.edu.ucne.boletosapp.data.remote

import com.edu.ucne.boletosapp.data.remote.dto.BoletosDto
import com.edu.ucne.boletosapp.data.remote.dto.EventosDto
import retrofit2.Response
import retrofit2.http.*

interface EventoApi {
    /* Usuario */
   /* @GET("/list/usuario")
    suspend fun getUsuarioById(@Path("id") id: Int): UsuariosDto

    @GET("/Usuario/{email},{clave}")
    suspend fun getClienteByLogin(
        @Path("email") email: String,
        @Path("clave") clave: String
    ): ClientesDto

    @POST("/api/Clientes")
    suspend fun postClientes(@Body clientesDto: ClientesDto)

    @PUT("/api/Clientes/{id}")
    suspend fun putClientes(@Path("id") id: Int, @Body clientesDto: ClientesDto): Response<Unit>
*/
    /* Evento */
    @GET("/list/evento")
    suspend fun getEvento(): List<EventosDto>
    @GET("/evento/{id}")
    suspend fun getEventoById(@Path("id") id: Int): EventosDto
    @PUT("/evento/update/{id}")
    suspend fun putEvento(@Path("id") id: Int, @Body eventosDto: EventosDto): List<EventosDto>
    @GET("/evento/{id}")
    suspend fun getEventobyId(@Path("id") id: Int): EventosDto


    /* Boleto */
    @GET("/list/boletos")
    suspend fun getBoletos(): List<BoletosDto>

    @GET("/boletos/{id}")
    suspend fun getBoletosById(@Path("id") id: Int): BoletosDto

    @PUT("/delete/evento{id}")
    suspend fun putBoleto(@Path("id") id: Int, @Body boletosDto: BoletosDto): Response<Unit>


/*
    /* Asientos */
    @GET("/list/asiento")
    suspend fun getAsientos(): List<AsientosDto>

    @GET("/asiento/{id}")
    suspend fun getAsientosById(@Path("id") id: Int): AsientosDto

    @POST("/save/asiento")
    suspend fun postAsientos(asientosDto: AsientosDto)

    @PUT("/update/asiento{id}")
    suspend fun putAsientos(@Path("id") id: Int, @Body asientosDto: AsientosDto): Response<Unit>

    @DELETE("/delete/asiento{id}")
    suspend fun deleteAsientos(@Path("id") id: Int)

    /* Secciones */
    @GET("/list/seccion/")
    suspend fun getSecciones(@Path("id") id: Int): List<SeccionesDto>

    @GET("/seccion/{seccionId}")
    suspend fun getSeccionesById(@Path("id") id: Int): SeccionesDto

    @GET("/save/seccion")
    suspend fun postSecciones(seccionesDto: SeccionesDto)

    @POST("/api/Citas")
    suspend fun postCita(@Body citaDto: CitaDto): CitaDto

    @PUT("/update/seccion{id}")
    suspend fun putSecciones(@Path("id") id: Int, @Body seccionesDto: SeccionesDto): Response<Unit>

    /* Categorias */
    @GET("/api/Estadoes")
    suspend fun getEstados() : List<EstadoDto>
    @GET("/api/Estadoes/{id}")
    suspend fun getEstadoById(@Path("id") id:Int) : EstadoDto*/

}