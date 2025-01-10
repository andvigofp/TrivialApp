package com.example.trivialapp.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.trivialapp.ui.state.TrivialViewModel

@Composable
fun GameOverScreen(
    viewModel: TrivialViewModel,
    onHome: () -> Unit,
    onReplay: () -> Unit
) {
    val finalScorePercentage = if (viewModel.totalQuestions > 0) {
        (viewModel.score * 100) / viewModel.totalQuestions
    } else {
        0
    }

    // Limitar el porcentaje entre 0 y 100
    val clampedScore = finalScorePercentage.coerceIn(0, 100)

    // Determinar el color de la puntuación final
    val scoreColor = when {
        clampedScore >= 80 -> MaterialTheme.colorScheme.primary // Alta puntuación: Verde
        clampedScore >= 50 -> MaterialTheme.colorScheme.secondary // Puntuación media
        else -> MaterialTheme.colorScheme.error // Baja puntuación: Rojo
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Juego Terminado",
            style = MaterialTheme.typography.headlineMedium
        )

        // Definir un color más oscuro para el fondo
        val lilacBackgroundColor = Color(0xFF8A4D92) // Lila claro
        val textColor = Color.White // Letras en blanco

        Text(
            text = "Puntuación final: $clampedScore%",
            style = MaterialTheme.typography.bodyLarge,
            color = textColor, // Cambiar el color del texto a blanco
            modifier = Modifier
                .background(lilacBackgroundColor) // Color de fondo oscuro
                .padding(8.dp) // Un poco de relleno alrededor del texto
        )

        // Botón para ir al inicio
        Button(
            onClick = { onHome() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Inicio")
        }

        // Botón para reiniciar el juego
        Button(
            onClick = onReplay,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Volver a jugar")
        }
    }
}


