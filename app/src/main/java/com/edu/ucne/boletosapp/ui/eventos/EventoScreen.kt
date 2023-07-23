package com.edu.ucne.boletosapp.ui.eventos

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventoScreen(
    eventoId: Int,
    viewModel: EventoViewModel = hiltViewModel(),
    onSaveClick: () -> Unit
) {
    remember {
        viewModel.setEvento(eventoId)
        0
    }
    EventoBody(viewModel = viewModel) {
        onSaveClick()
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EventoBody(
    viewModel: EventoViewModel,
    onSaveClick: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val intNombreEventoSource = remember {
        MutableInteractionSource()
    }
    val nombreEventoFocus by intNombreEventoSource.collectIsFocusedAsState()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { },
        //elevation = 8.dp
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Registro De Eventos",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    modifier = Modifier
                        .padding(8.dp),

                    //text = { Text("Guardar") },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Save,
                            contentDescription = "Save"
                        )
                    },
                    onClick = {
                       viewModel.putEvento()
                        onSaveClick()
                    }
                )
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = viewModel.nombreEvento,
                    onValueChange = { viewModel.nombreEvento = it },
                    label = { Text("Nombre Evento") }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = viewModel.descripcion,
                    onValueChange = { viewModel.descripcion = it },
                    label = { Text("Descripcion") }
                )
               /* OutlinedTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { expanded = true },
                    value = viewModel,
                    enabled = false, readOnly = true,
                    onValueChange = { viewModel.estatus = it },
                    label = { Text("Estatus") }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)

                ) {
                    viewModel.opcionesEstatus.forEach { opcion ->
                        DropdownMenuItem(
                            text = {
                                Text(text = opcion, textAlign = TextAlign.Center)
                            },
                            onClick = {
                                expanded = false
                                viewModel.estatus = opcion
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)
                        )
                    }
                }*/
                OutlinedTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = viewModel.fecha,
                    onValueChange = { viewModel.fecha = it },
                    label = { Text("Fecha") }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = viewModel.ubicacion,
                    onValueChange = { viewModel.ubicacion = it },
                    label = { Text("Ubicacion") }
                )

            }
        }
    }
}
