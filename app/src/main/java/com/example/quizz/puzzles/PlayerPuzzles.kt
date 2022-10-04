package com.example.quizz.puzzles

//class PlayerPuzzles : ArrayList<PlayerPuzzlesItem>()

//data class PlayerPuzzlesItem(
//    val author: String,
//    val creating_date: String,
//    val id: Int,
//    val name: String,
//    val player_cards: List<Int>
//)
class PuzzleCollection : ArrayList<PuzzleCollectionItem>()

data class PuzzleCollectionItem(
    val creating_date: String,
    val id: Int,
    val name: String,
    val player_items: List<Int>,
    val status: String
)
