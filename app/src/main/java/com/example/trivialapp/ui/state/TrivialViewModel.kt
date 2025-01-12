package com.example.trivialapp.ui.state

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.trivialapp.data.QuestionDataSource
import com.example.trivialapp.model.Question




class TrivialViewModel(private val context: Context) : ViewModel() {

    private val _questions = SnapshotStateList<Question>()
    val questionsMutable: SnapshotStateList<Question> get() = _questions
    val questions: List<Question> get() = _questions

    private val _totalQuestions = mutableStateOf(0)
    val totalQuestions: Int get() = _totalQuestions.value
    fun updateTotalQuestions(value: Int) {
        _totalQuestions.value = value
    }

    private val _currentQuestionIndex = mutableStateOf(0)
    var currentQuestionIndex: Int
        get() = _currentQuestionIndex.value
        private set(value) {
            _currentQuestionIndex.value = value
        }
    fun updateCurrentQuestionIndex(value: Int) {
        _currentQuestionIndex.value = value
    }

    private val _score = mutableStateOf(0)
    var score: Int
        get() = _score.value
        private set(value) {
            _score.value = value
        }
    fun updateScore(value: Int) {
        _score.value = value
    }

    private val _record = mutableStateOf(0)
    val record: Int get() = _record.value
    fun updateRecord(value: Int) {
        _record.value = value
    }

    private val _gameOver = mutableStateOf(false)
    val gameOver: Boolean get() = _gameOver.value
    fun updateGameOver(value: Boolean) {
        _gameOver.value = value
    }

    private val _answerShown = mutableStateOf(false)
    val answerShown: Boolean get() = _answerShown.value
    fun updateAnswerShown(value: Boolean) {
        _answerShown.value = value
    }

    private val gameFunctions = GameFunctions(this)

    // Llamada a funciones del juego
    fun startGame(questionCount: Int) = gameFunctions.startGame(questionCount)
    fun submitAnswer(selectedIndex: Int) = gameFunctions.submitAnswer(selectedIndex)
    fun moveToNextQuestion() = gameFunctions.moveToNextQuestion()
    fun checkAndUpdateRecord(percentage: Int = (score * 100 / totalQuestions).coerceAtLeast(0)) = gameFunctions.checkAndUpdateRecord(percentage)
}












