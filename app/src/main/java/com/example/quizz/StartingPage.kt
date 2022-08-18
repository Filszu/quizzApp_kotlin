package com.example.quizz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StartingPage : AppCompatActivity() {

    private lateinit var quizzListContainer:LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting_page)

        val tvQ1Name = findViewById<TextView>(R.id.tv_quizz1Name)
        quizzListContainer = findViewById<LinearLayout>(R.id.quizListContainer)


        addQuizView()


        tvQ1Name.setOnClickListener {


            parseJSONtoOBJ(this)

            /*
            val jsonFileString = getJsonDataFromAsset(applicationContext, "avaibleQuizess.json")
            if (jsonFileString != null) {
                Log.i("data", jsonFileString)
            }
            val gson = Gson()




            var avaibleQuizess = gson.fromJson(jsonFileString, avaibleQuizz::class.java)
            avaibleQuizess.forEachIndexed { idx, avaibleQuizz -> Log.i("data", "> Item $idx:\n$avaibleQuizz") }
            Toast.makeText(this,
                "${avaibleQuizess[0].name.toString()}", Toast.LENGTH_LONG).show()

        }

             */


    }
}

fun parseJSONtoOBJ(applicationContext: Context){


    val jsonFileString = getJsonDataFromAsset(applicationContext, "avaibleQuizess.json")
    if (jsonFileString != null) {
        Log.i("data", jsonFileString)
    }
    val gson = Gson()




    var avaibleQuizess = gson.fromJson(jsonFileString, avaibleQuizz::class.java)
    avaibleQuizess.forEachIndexed { idx, avaibleQuizz -> Log.i("data", "> Item $idx:\n$avaibleQuizz") }

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

    fun addQuizView(){

        val quizItemView:View = layoutInflater.inflate(R.layout.available_quizz_item_layout, null, false)

        var editText:TextView = quizItemView.findViewById(R.id.tv_quizzName)

        quizzListContainer.addView(quizItemView)

    }

}