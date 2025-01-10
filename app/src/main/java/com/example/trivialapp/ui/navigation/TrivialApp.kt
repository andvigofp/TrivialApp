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
                    // Asegúrate de actualizar el récord antes de ir a GameOverScreen
                    viewModel.updateRecordIfNeeded()  // Actualiza el récord en el ViewModel
                    navController.navigate(TrivialScreen.GameOver.name)
                }
            )
        }
        composable(TrivialScreen.GameOver.name) {
            GameOverScreen(
                viewModel = viewModel,
                onHome = {
                    // Actualiza el récord aquí también si es necesario antes de navegar a Home
                    viewModel.updateRecordIfNeeded()
                    navController.navigate(TrivialScreen.Home.name) {
                        popUpTo(TrivialScreen.Home.name) { inclusive = true }
                    }
                },
                onReplay = {
                    // Reinicia el juego y navega a Game
                    viewModel.startGame(viewModel.totalQuestions)  // Reinicia el juego
                    navController.navigate(TrivialScreen.Game.name) {
                        popUpTo(TrivialScreen.GameOver.name) { inclusive = true }
                    }
                }
            )
        }
    }
}







