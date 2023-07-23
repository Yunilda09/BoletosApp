package com.edu.ucne.boletosapp.ui.componentes
/*
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.edu.ucne.boletosapp.data.remote.dto.Evento
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun EventoRow(
    evento: Evento,
    onEventoClick: (Int) -> Unit
){
    val offsetY = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onEventoClick(evento.Id) }
        .offset {
            IntOffset(offsetY.value.roundToInt(), 0)
        }
        .draggable(
            state = rememberDraggableState { delta ->
                coroutineScope.launch {
                    offsetY.snapTo(offsetY.value + delta)
                }
            },
            orientation = Orientation.Horizontal,
            onDragStopped = {
                coroutineScope.launch {
                    offsetY.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            delayMillis = 100
                        )
                    )
                    if (evento.boletoId == 1)
                       // onCitaSwipe(evento.Id)
                }
            }
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .padding(horizontal = 4.dp)
                .fillMaxWidth()
        ) {
            if(evento.boletoId!=1)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = evento.nombreEvento,
                        style = MaterialTheme.typography.titleSmall,
                        //color = Rosa10
                    )
                }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                /*Text(
                    text = evento.descripcion,
                    style = MaterialTheme.typography.titleMedium,
                   // color = Rosa10
                )*/
                Text(
                    text = evento.fecha,
                    //color = Rosa10
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(
                    text = evento.ubicacion,
                    style = MaterialTheme.typography.titleSmall,
                   // color = Rosa10
                )

            }
        }
    }
}
*/