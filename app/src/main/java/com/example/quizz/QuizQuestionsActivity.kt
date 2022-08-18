package com.example.quizz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurPos: Int = 1
    private var mQList: ArrayList<QuestionItem>?=null
    private var mSelectedOption : Int = 0
    private var activePanel: Boolean = true
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    private var progressBar:ProgressBar?=null
    private lateinit var  tv_progress:TextView
    private lateinit var tv_q:TextView
    private lateinit var iv_img:ImageView
    private lateinit var tv_A:TextView
    private lateinit var tv_B:TextView
    private lateinit var tv_C:TextView
    private lateinit var tv_D:TextView
    private lateinit var btn_submit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(QuizQuestionsList.USER_NAME)

        QuizQuestionsList.parseJSONtoOBJ(this)
        mQList = QuizQuestionsList.getQuestions()
//        Log.i("Q size", "${questionsList.size}")

        progressBar= findViewById<ProgressBar>(R.id.progressBar)
        tv_progress = findViewById<TextView>(R.id.tv_progress)
        tv_q = findViewById<TextView>(R.id.tv_question)
        iv_img = findViewById<ImageView>(R.id.iv_image)
        tv_A = findViewById<TextView>(R.id.optionA)
        tv_B = findViewById<TextView>(R.id.optionB)
        tv_C = findViewById<TextView>(R.id.optionC)
        tv_D = findViewById<TextView>(R.id.optionD)
        btn_submit = findViewById<Button>(R.id.btn_submit)

        tv_A.setOnClickListener(this)
        tv_B.setOnClickListener(this)
        tv_C.setOnClickListener(this)
        tv_D.setOnClickListener(this)
        btn_submit.setOnClickListener(this)



        setQuestion()




    }

    private fun setQuestion(){
//        mCurPos =3
//        val question: Question? = questionsList[currPosition-1]

        val question = mQList!![mCurPos-1]

        defaultOptionView()

        if(mCurPos == mQList!!.size){
            btn_submit.text = "⏪FINISH⏩"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar?.progress = mCurPos
        progressBar?.max=mQList!!.size

        tv_progress.text = "$mCurPos/${progressBar?.max}"
        tv_q.text = question!!.question
//        iv_img.setImageResource(question.img)

        val currQImg = question.img
        iv_img.setImageResource(resources.getIdentifier(currQImg, "drawable", packageName))


        Toast.makeText(this,
            "tcurr img ${currQImg}", Toast.LENGTH_LONG).show()

        tv_A.text = question.optionA
        tv_B.text = question.optionB
        tv_C.text = question.optionC
        tv_D.text = question.optionD



    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_A)
        options.add(1,tv_B)
        options.add(2,tv_C)
        options.add(3,tv_D)

        for (option in options) {
            option.setTextColor(Color.parseColor("#1E1E20"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }


    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.optionA ->{
                selectedOption(tv_A,1)
            }
            R.id.optionB ->{
                selectedOption(tv_B,2)
            }
            R.id.optionC ->{
                selectedOption(tv_C,3)
            }
            R.id.optionD ->{
                selectedOption(tv_D,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOption==0){
                    mCurPos++

                    when{
                        mCurPos <= mQList!!.size ->{
                            activePanel=true
                            setQuestion()
                        }else->{
                        Toast.makeText(this,
                            "U have completed quizz ", Toast.LENGTH_LONG).show()

                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(QuizQuestionsList.USER_NAME, mUserName)
                            intent.putExtra(QuizQuestionsList.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(QuizQuestionsList.TOTAL_QUESTIONS, mQList!!.size)
                            startActivity(intent)
                            finish()
                        }

                    }
                }else{
                    val question = mQList?.get(mCurPos-1)
                    if(question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurPos == mQList!!.size){
                        activePanel=false
                        btn_submit.text = "finish"
                    }else{
                        activePanel=false
                        btn_submit.text = "next"
                    }
                    mSelectedOption=0
                }
            }
        }

    }

    private fun selectedOption(tv: TextView, selectedOption: Int){
        if(activePanel) {
            defaultOptionView()
            mSelectedOption = selectedOption

            tv.setTextColor(Color.parseColor("#364a43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when (answer) {
            1->{
                tv_A.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                tv_B.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                tv_C.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                tv_D.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}