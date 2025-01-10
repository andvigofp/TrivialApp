package com.example.trivialapp.data

import com.example.trivialapp.model.Question


object QuestionDataSource {
    val questions = listOf(
        Question(
            question = "¿Cuál es la capital de Francia?",
            options = listOf("Madrid", "París", "Berlín", "Roma"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Cuál es el río más largo del mundo?",
            options = listOf("Nilo", "Amazonas", "Yangtsé", "Misisipi"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Quién pintó la Mona Lisa?",
            options = listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "¿Cuál es el planeta más grande del sistema solar?",
            options = listOf("Tierra", "Marte", "Júpiter", "Saturno"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "¿En qué año llegó el hombre a la Luna?",
            options = listOf("1965", "1969", "1972", "1980"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Cuál es el océano más grande del mundo?",
            options = listOf("Atlántico", "Índico", "Ártico", "Pacífico"),
            correctAnswerIndex = 3
        ),
        Question(
            question = "¿Quién escribió 'Cien años de soledad'?",
            options = listOf("Gabriel García Márquez", "Mario Vargas Llosa", "Julio Cortázar", "Jorge Luis Borges"),
            correctAnswerIndex = 0
        ),
        Question(
            question = "¿Cuál es el metal más abundante en la corteza terrestre?",
            options = listOf("Hierro", "Aluminio", "Cobre", "Plata"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Cuál es el país más grande del mundo?",
            options = listOf("China", "Estados Unidos", "Canadá", "Rusia"),
            correctAnswerIndex = 3
        ),
        Question(
            question = "¿Cuál es el idioma más hablado en el mundo?",
            options = listOf("Inglés", "Español", "Chino mandarín", "Hindú"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "¿Cuál es el continente más grande del mundo?",
            options = listOf("Asia", "América", "África", "Europa"),
            correctAnswerIndex = 0
        ),
        Question(
            question = "¿En qué año comenzó la Segunda Guerra Mundial?",
            options = listOf("1914", "1939", "1945", "1929"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Quién fue el primer presidente de los Estados Unidos?",
            options = listOf("Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Qué gas es esencial para la respiración humana?",
            options = listOf("Oxígeno", "Nitrógeno", "Dióxido de carbono", "Helio"),
            correctAnswerIndex = 0
        ),
        Question(
            question = "¿Qué ciudad es conocida como 'La Ciudad Eterna'?",
            options = listOf("Roma", "Atenas", "Estambul", "Cairo"),
            correctAnswerIndex = 0
        ),
        Question(
            question = "¿Quién es conocido como el padre de la teoría de la relatividad?",
            options = listOf("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Cuál es el animal terrestre más grande del mundo?",
            options = listOf("Elefante africano", "Ballena azul", "Rinoceronte blanco", "Hipopótamo"),
            correctAnswerIndex = 0
        ),
        Question(
            question = "¿Quién fue el autor de 'Don Quijote de la Mancha'?",
            options = listOf("Lope de Vega", "Miguel de Cervantes", "Garcilaso de la Vega", "Felipe II"),
            correctAnswerIndex = 1
        ),
        Question(
            question = "¿Cuál es la montaña más alta del mundo?",
            options = listOf("K2", "Kangchenjunga", "Monte Everest", "Makalu"),
            correctAnswerIndex = 2
        ),
        Question(
            question = "¿Cuál es el animal marino más grande?",
            options = listOf("Tiburón blanco", "Ballena azul", "Delfín", "Orca"),
            correctAnswerIndex = 1
        )
    )
}
