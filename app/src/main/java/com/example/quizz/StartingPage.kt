package com.example.quizz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StartingPage : AppCompatActivity() {

    private lateinit var quizzListContainer:LinearLayout
    private lateinit var avaibleQuizess:ArrayList<avaibleQuizzItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting_page)

        quizzListContainer = findViewById<LinearLayout>(R.id.quizListContainer)

        parseJSONtoOBJ(this)
        createFromQuizList()




}

fun parseJSONtoOBJ(applicationContext: Context){


    val jsonFileString = getJsonDataFromAsset(applicationContext, "avaibleQuizess.json")
    if (jsonFileString != null) {
        Log.i("data", jsonFileString)
    }
    val gson = Gson()




    avaibleQuizess = gson.fromJson(jsonFileString, avaibleQuizz::class.java)
//    avaibleQuizess.forEachIndexed { idx, avaibleQuizz -> Log.i("data", "> Item $idx:\n$avaibleQuizz") }

    Toast.makeText(
        applicationContext,
        "${avaibleQuizess[1]?.name}", Toast.LENGTH_LONG
    ).show()

//    try {
//        Toast.makeText(
//            applicationContext,
//            "${avaibleQuizess[2]?.name}", Toast.LENGTH_LONG
//        ).show()
//    }catch (e: Exception) {
//        Toast.makeText(
//            applicationContext,
//            "$e", Toast.LENGTH_LONG
//        ).show()
//    }

}

    private fun createFromQuizList(){
        for(el in avaibleQuizess){
            addQuizView(el)
        }
    }

    private fun addQuizView(quizItem:avaibleQuizzItem){

        //create based on template
        val quizItemView:View = layoutInflater.inflate(R.layout.available_quizz_item_layout, null, false)


        var editText:TextView = quizItemView.findViewById(R.id.tv_quizzName)
        editText.text = quizItem.name

        val cardView: CardView = quizItemView.findViewById(R.id.cv_quizzItem)

        cardView.setOnClickListener {
            startQuiz(quizItem.id)
        }

        //adding to view
        quizzListContainer.addView(quizItemView)

    }

    private fun startQuiz(quizID:Int){
        Toast.makeText(
            applicationContext,
            "Quiz id: ${quizID}", Toast.LENGTH_LONG
        ).show()
    }
}


