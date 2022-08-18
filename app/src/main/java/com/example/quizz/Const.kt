package com.example.quizz

class Const {
    public val abc = "dsfsdfs"
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1= Question(1,"country flag",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Germany", "Australia", "UK",
            1,
        )
        questionsList.add(q1)

        val q2= Question(2,"country flag",
            R.drawable.ic_flag_of_australia,
            "Argentina","Germany", "Australia", "UK",
            3,
        )
        questionsList.add(q2)

        val q3= Question(3,"country flag",
            R.drawable.ic_flag_of_belgium,
            "Argentina","Germany", "Australia", "Belgium",
            4,
        )
        questionsList.add(q3)

        val q4= Question(4,"country flag",
            R.drawable.ic_flag_of_india,
            "India","Germany", "Australia", "UK",
            1,
        )
        questionsList.add(q4)

        val q5= Question(5,"country flag",
            R.drawable.ic_flag_of_denmark,
            "Argentina","Denmark", "Australia", "UK",
            2,
        )
        questionsList.add(q5)


        return questionsList
    }
}