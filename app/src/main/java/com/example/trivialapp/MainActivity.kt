package com.example.trivialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trivialapp.ui.navigation.TrivialApp
import com.example.trivialapp.ui.state.TrivialViewModel
import com.example.trivialapp.ui.state.TrivialViewModelFactory
import com.example.trivialapp.ui.theme.TrivialAppTheme

class MainActivity : ComponentActivity() {
    // Usamos la fábrica para obtener el ViewModel
    private val viewModel: TrivialViewModel by viewModels {
        TrivialViewModelFactory(application)  // Crear el ViewModel con la fábrica
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrivialAppTheme {
                TrivialApp(viewModel)  // Pasamos el ViewModel a la UI
            }
        }
    }

    @Composable
    fun GreetingPreview() {
        TrivialAppTheme {
            TrivialApp(viewModel)  // Pasamos el ViewModel a la UI
        }
    }
}