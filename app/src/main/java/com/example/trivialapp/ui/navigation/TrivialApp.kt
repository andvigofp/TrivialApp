package com.example.trivialapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp.ui.Screens.GameOverScreen
import com.example.trivialapp.ui.Screens.GameScreen
import com.example.trivialapp.ui.Screens.HomeScreen
import com.example.trivialapp.ui.state.TrivialViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TrivialApp(viewModel: TrivialViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TrivialScreen.Home.name
    ) {
        composable(TrivialScreen.Home.name) {
            HomeScreen(
                viewModel = viewModel,
                onStartGame = { navController.navigate(TrivialScreen.Game.name) },
                onNavigateToGameOver = { navController.navigate(TrivialScreen.GameOver.name) }
            )
        }
        composable(TrivialScreen.Game.name) {
            GameScreen(
                viewModel = viewModel,
                onGameOver = {
                    // Navega a la pantalla de Game Over
                    navController.navigate(TrivialScreen.GameOver.name)
                }
            )
        }
        composable(TrivialScreen.GameOver.name) {
            GameOverScreen(
                viewModel = viewModel,
                onHome = {
                    navController.navigate(TrivialScreen.Home.name) {
                        popUpTo(TrivialScreen.Home.name) { inclusive = true }
                    }
                },
                onReplay = {
                    // Reinicia el juego y navega a la pantalla de juego
                    viewModel.startGame(viewModel.totalQuestions) // Reinicia el juego con la misma cantidad de preguntas
                    navController.navigate(TrivialScreen.Game.name) {
                        popUpTo(TrivialScreen.GameOver.name) { inclusive = true }
                    }
                }
            )
        }
    }
}








