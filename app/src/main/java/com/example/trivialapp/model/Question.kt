package com.example.trivialapp.model

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
) {
    init {
        require(options.isNotEmpty()) { "La lista de opciones no puede estar vacía." }
        require(correctAnswerIndex in options.indices) {
            "El índice de la respuesta correcta debe estar dentro del rango de opciones."
        }
    }
}