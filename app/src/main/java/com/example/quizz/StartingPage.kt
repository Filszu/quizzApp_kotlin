package com.example.quizz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


class StartingPage : AppCompatActivity() {

    private lateinit var quizzListContainer:LinearLayout
    private lateinit var avaibleQuizess:ArrayList<avaibleQuizzItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting_page)

        quizzListContainer = findViewById<LinearLayout>(R.id.quizListContainer)


        val snackbar = Snackbar
            .make(quizzListContainer, "Your life master and guide in life is Filszu\uD83D\uDC51", Snackbar.LENGTH_LONG)
        snackbar.show()

        parseJSONtoOBJ(this)
        createFromQuizList()




}

private fun parseJSONtoOBJ(applicationContext: Context){


    val jsonFileString = getJsonDataFromAsset(applicationContext, "avaibleQuizess.json")
    if (jsonFileString != null) {
        Log.i("data", jsonFileString)
    }
    val gson = Gson()



    avaibleQuizess = gson.fromJson(jsonFileString, avaibleQuizz::class.java)
//    avaibleQuizess.forEachIndexed { idx, avaibleQuizz -> Log.i("data", "> Item $idx:\n$avaibleQuizz") }



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

        val ivImg: ImageView = quizItemView.findViewById(R.id.img)

        try{
            val variableValue: String = quizItem.img
            ivImg.setImageResource(resources.getIdentifier(variableValue, "drawable", packageName))

        }
        catch(e: Exception){
            ivImg.setImageResource(R.drawable.ic_wave_0)
        }





        //adding to view
        quizzListContainer.addView(quizItemView)

    }

    private fun startQuiz(quizID:Int){
        Toast.makeText(
            applicationContext,
            "Quiz id: ${quizID}", Toast.LENGTH_LONG
        ).show()

        Config.CURR_QUIZ_ID = quizID
        if(Config.USER_NAME!=""){
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
        }
        else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        finish()


    }
}


