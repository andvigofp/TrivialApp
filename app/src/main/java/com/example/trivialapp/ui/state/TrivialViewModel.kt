package com.example.trivialapp.ui.state

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.trivialapp.data.QuestionDataSource
import com.example.trivialapp.model.Question


class TrivialViewModel(private val context: Context) : ViewModel() {

    private val allQuestions = QuestionDataSource.questions.shuffled()

    private val _questions = SnapshotStateList<Question>()
    val questions: List<Question> get() = _questions

    private val _totalQuestions = mutableStateOf(0)
    val totalQuestions: Int get() = _totalQuestions.value

    private val _currentQuestionIndex = mutableStateOf(0)
    var currentQuestionIndex: Int
        get() = _currentQuestionIndex.value
        private set(value) {
            _currentQuestionIndex.value = value
        }

    private val _score = mutableStateOf(0)
    var score: Int
        get() = _score.value
        private set(value) {
            _score.value = value
        }

    private val _record = mutableStateOf(loadRecord())
    val record: Int get() = _record.value

    private val _gameOver = mutableStateOf(false)
    val gameOver: Boolean get() = _gameOver.value

    private val _answerShown = mutableStateOf(false)
    val answerShown: Boolean get() = _answerShown.value

    init {
        _record.value = loadRecord()
    }

    fun startGame(questionCount: Int) {
        _questions.clear()
        _questions.addAll(allQuestions.shuffled().take(questionCount))
        _totalQuestions.value = questionCount
        currentQuestionIndex = 0
        score = 0
        _gameOver.value = false
        _answerShown.value = false
    }

    fun submitAnswer(selectedIndex: Int) {
        val currentQuestion = questions[currentQuestionIndex]

        if (!_answerShown.value) {
            // Incrementa la puntuación si la respuesta es correcta
            if (selectedIndex == currentQuestion.correctAnswerIndex) {
                score++
            }
            _answerShown.value = true
        }
    }

    fun moveToNextQuestion() {
        if (currentQuestionIndex < questions.lastIndex) {
            currentQuestionIndex++
        } else {
            _gameOver.value = true
            checkAndUpdateRecord()
        }

        _answerShown.value = false
    }

    private fun checkAndUpdateRecord() {
        // Actualiza el récord solo si el puntaje es mayor
        if (score > _record.value) {
            _record.value = score
            saveRecord(score)
        }
    }

    // Método para actualizar el récord si la puntuación es mayor
    fun updateRecordIfNeeded() {
        if (score > _record.value) {
            _record.value = score
            saveRecord(score)  // Guardamos el nuevo récord
        }
    }

    private fun saveRecord(record: Int) {
        val sharedPref = context.getSharedPreferences("TrivialAppPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("record", record)
            apply()
        }
    }

    private fun loadRecord(): Int {
        val sharedPref = context.getSharedPreferences("TrivialAppPrefs", Context.MODE_PRIVATE)
        return sharedPref.getInt("record", 0)
    }
}







