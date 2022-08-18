package com.example.quizz

data class Question(
    val id: Int,
    val question: String,
    val img: Int,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: Int


)


