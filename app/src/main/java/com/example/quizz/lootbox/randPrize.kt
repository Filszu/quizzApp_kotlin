package com.example.quizz.lootbox

import com.example.quizz.Config


var prize_card_img_id = ""
var prize_card_set=""
fun randCard(){

    val cardSetsCount = Config.AVAIBLE_PUZZLES_COUNT
//    save and read to json

    val card_img_id = (1..9).random()
    val card_set=(1..cardSetsCount).random()

    prize_card_img_id=card_img_id.toString()
    prize_card_set=card_set.toString()


//    get avaible quizes .len
}

fun haveOrNot(){

}
