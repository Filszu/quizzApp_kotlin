package com.example.quizz


class Question : ArrayList<QuestionItem>()

data class QuestionItem(
    val correctAnswer: Int,
    val id: Int,
    val img: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val question: String
)

//data class Question(
//    val id: Int,
//    val question: String,
//    val img: Int,
//    val optionA: String,
//    val optionB: String,
//    val optionC: String,
//    val optionD: String,
//    val correctAnswer: Int
//
//
//)
//
