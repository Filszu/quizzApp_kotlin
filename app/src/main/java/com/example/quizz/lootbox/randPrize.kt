package com.example.quizz.lootbox


var prize_card_img_id = ""
var prize_card_set=""
fun randCard(){

    val cardSetsCount = 1
//    save and read to json

    val card_img_id = (1..9).random()
    val card_set="1"

    prize_card_img_id=card_img_id.toString()
    prize_card_set=card_set


}

fun haveOrNot(){

}
