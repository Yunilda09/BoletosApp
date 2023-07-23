package com.edu.ucne.boletosapp.ui.eventos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.edu.ucne.boletosapp.data.remote.dto.EventosDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventoListScreen(
    onNewEvento: () -> Unit, viewModel: EventoViewModel = hiltViewModel(),
    onEventoClick: (Int) -> Unit
){
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = onNewEvento) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar evento")
            }
        },
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Eventos",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge) }
            )
        },
    ) {
        val uiState by viewModel.uiState.collectAsState()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            EventoListBody(uiState.evento) {
                onEventoClick(it)
            }
        }
    }
}

@Composable
fun EventoListBody( eventoList: List<EventosDto>, onEventoClick: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn {
            items(eventoList) { evento ->
                EventoRow( evento = evento) {
                    onEventoClick(it)
                }
            }
        }
    }
}

@Composable
fun EventoRow(evento: EventosDto, onEventoClick: (Int) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onEventoClick(evento.eventoId) })
        ) {
            Row() {
                Text(
                    text ="Nombre Evento: ${evento.nombreEvento}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(3f)
                )
                Text(
                    text = evento.fecha.substring(0, 10),
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(3f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = evento.descripcion,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(3f)
                )
                Text(
                    text = evento.ubicacion,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(3f)
                )
            }
        }
        Divider(Modifier.fillMaxWidth())
    }
}

