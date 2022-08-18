package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(QuizQuestionsList.USER_NAME)

        val tvUserName = findViewById<TextView>(R.id.tv_userName)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btn = findViewById<Button>(R.id.btn_finish)

        tvUserName.text = username

        val totalQ = intent.getIntExtra(QuizQuestionsList.TOTAL_QUESTIONS, 0)
        val correctA = intent.getIntExtra(QuizQuestionsList.CORRECT_ANSWERS, 0)

        tvScore.text = "your score: $correctA / $totalQ"

        btn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}