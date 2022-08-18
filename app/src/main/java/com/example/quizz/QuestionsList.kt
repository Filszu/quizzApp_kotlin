package com.example.quizz

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson

object QuizQuestionsList{

    const val USER_NAME: String = "userName"
    const val TOTAL_QUESTIONS: String = "totalQuestions"
    const val CORRECT_ANSWERS: String = "correctAnswer"

    var questionsList = ArrayList<QuestionItem>()

    fun getQuestions(): ArrayList<QuestionItem> {
        Log.i("Q_list", "${questionsList[0].question}")
        return questionsList
    }

    fun parseJSONtoOBJ(applicationContext: Context){

//        val jsonFileString = getJsonDataFromAsset(applicationContext, "${Config.CURR_QUIZ_ID}.json")
        val jsonFileString = getJsonDataFromAsset(applicationContext, "1.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val gson = Gson()



        questionsList  = gson.fromJson(jsonFileString, Question::class.java)
//    avaibleQuizess.forEachIndexed { idx, avaibleQuizz -> Log.i("data", "> Item $idx:\n$avaibleQuizz") }

        Toast.makeText(
            applicationContext,
            "${questionsList[1]?.correctAnswer}", Toast.LENGTH_LONG
        ).show()


    }
}