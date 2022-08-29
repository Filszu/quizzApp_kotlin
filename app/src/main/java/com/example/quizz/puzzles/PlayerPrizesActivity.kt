package com.example.quizz.puzzles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.quizz.R
import com.example.quizz.databinding.ActivityPlayerPrizesBinding
import com.example.quizz.getJsonDataFromAsset
import com.google.gson.Gson

class PlayerPrizesActivity : AppCompatActivity() {


    private lateinit var avaiblePuzzles:ArrayList<PlayerPuzzlesItem>
    private lateinit var binding: ActivityPlayerPrizesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_prizes)

        binding = ActivityPlayerPrizesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        parseJSONtoOBJ(this)

    }

    private fun parseJSONtoOBJ(applicationContext: Context){


        val jsonFileString = getJsonDataFromAsset(applicationContext, "avaibleQuizess.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val gson = Gson()



        avaiblePuzzles = gson.fromJson(jsonFileString, PlayerPuzzles::class.java)
        createFromPuzzlesList()

    }

    private fun createFromPuzzlesList(){
        for(el in avaiblePuzzles) {
            addPuzzleView(el)
        }
    }


    private fun addPuzzleView(item:PlayerPuzzlesItem){

        //create based on template
        val puzzleItemView: View = layoutInflater.inflate(R.layout.available_quizz_item_layout, null, false)


        var editText: TextView = puzzleItemView.findViewById(R.id.tv_quizzName)
        editText.text = "???"


        val cardView: CardView = puzzleItemView.findViewById(R.id.cv_quizzItem)

        cardView.setOnClickListener {
//            startQuiz(quizItem.id)
        }


        val ivImg: ImageView = puzzleItemView.findViewById(R.id.img)

        //adding to view
        binding.quizListContainer.addView(puzzleItemView)


    }
}


