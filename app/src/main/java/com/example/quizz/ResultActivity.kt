package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizz.puzzles.PlayerPrizesActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        val username = intent.getStringExtra(QuizQuestionsList.USER_NAME)
        val username = Config.USER_NAME

        val tvUserName = findViewById<TextView>(R.id.tv_userName)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btn = findViewById<Button>(R.id.btn_finish)

        tvUserName.text = username

        val totalQ = intent.getIntExtra(QuizQuestionsList.TOTAL_QUESTIONS, 0)
        val correctA = intent.getIntExtra(QuizQuestionsList.CORRECT_ANSWERS, 0)

        Config.TOTAL_CORRECT_A+=correctA
        Config.TOTAL_WRONG_A+=(totalQ-correctA)
        Config.TOTAL_QUIZES_COMPLETED++

        tvScore.text = "your score: $correctA / $totalQ"

        if(correctA == totalQ){
            Config.CAN_OPEN_CHEST=true
        }

        btn.setOnClickListener{
            startActivity(Intent(this, StartingPage::class.java))
        }


    }
    fun goToYourCollection(){
        val intent = Intent(this, PlayerPrizesActivity::class.java)
        startActivity(intent)
    }
}
//fun  goToYourCollection(){
//
//}
