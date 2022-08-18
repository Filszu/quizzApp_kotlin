package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnStart =findViewById<Button>(R.id.btn_Start)
        val etName = findViewById<TextView>(R.id.eT_name)

        btnStart.setOnClickListener {

            if(etName.text.isEmpty()){
                Toast.makeText(
                    this,
                    "insert your name", Toast.LENGTH_LONG
                ).show()
            }
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(QuizQuestionsList.USER_NAME, etName.text.toString())
                Config.USER_NAME=etName.text.toString()
                startActivity(intent)
                finish()

            }
        }

    }
}

//private fun btn_start?.setOnClickListener(unit: Unit) {
//
//}
