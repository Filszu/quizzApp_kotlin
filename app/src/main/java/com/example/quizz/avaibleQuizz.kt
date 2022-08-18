package com.example.quizz

class avaibleQuizz : ArrayList<avaibleQuizzItem>()

data class avaibleQuizzItem(
    val author: String,
    val category: String,
    val creating_date: String,
    val name: String
)