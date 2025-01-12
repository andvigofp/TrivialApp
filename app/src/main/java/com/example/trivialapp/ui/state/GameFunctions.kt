package com.example.trivialapp.ui.state

import com.example.trivialapp.data.QuestionDataSource
import com.example.trivialapp.ui.state.TrivialViewModel


class GameFunctions(private val viewModel: TrivialViewModel) {

    private val allQuestions = QuestionDataSource.questions.shuffled()

    // Inicia el juego con un número específico de preguntas
    fun startGame(questionCount: Int) {
        viewModel.questionsMutable.clear()
        viewModel.questionsMutable.addAll(allQuestions.shuffled().take(questionCount))
        viewModel.updateTotalQuestions(questionCount)
        viewModel.updateCurrentQuestionIndex(0)
        viewModel.updateScore(0)
        viewModel.updateGameOver(false)
        viewModel.updateAnswerShown(false)
    }

    // Envía la respuesta seleccionada por el usuario
    fun submitAnswer(selectedIndex: Int) {
        val currentQuestion = viewModel.questions[viewModel.currentQuestionIndex]

        if (!viewModel.answerShown) {
            if (selectedIndex == currentQuestion.correctAnswerIndex) {
                viewModel.updateScore(viewModel.score + 1)
            }
            viewModel.updateAnswerShown(true)
        }
    }

    // Avanza a la siguiente pregunta o finaliza el juego
    fun moveToNextQuestion() {
        if (viewModel.currentQuestionIndex < viewModel.questions.lastIndex) {
            viewModel.updateCurrentQuestionIndex(viewModel.currentQuestionIndex + 1)
        } else {
            viewModel.updateGameOver(true)
            checkAndUpdateRecord() // Actualiza el récord al final del juego
        }
        viewModel.updateAnswerShown(false)
    }

    // Método público para actualizar el récord
    fun checkAndUpdateRecord(percentage: Int = (viewModel.score * 100 / viewModel.totalQuestions).coerceAtLeast(0)) {
        if (percentage > viewModel.record) {
            viewModel.updateRecord(percentage)
        }
    }
}



