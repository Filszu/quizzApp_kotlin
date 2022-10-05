package com.example.quizz.puzzleView

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.quizz.Config
import com.example.quizz.R
import com.example.quizz.databinding.ActivityPlayerPrizesBinding
import com.example.quizz.databinding.ActivityPuzzleViewBinding
import com.example.quizz.puzzles.PlayerPrizesActivity
import com.example.quizz.puzzles.PuzzleCollectionItem
import com.example.quizz.puzzles.currPuzzle
import java.io.IOException
import java.io.InputStream


class PuzzleViewActivity : AppCompatActivity() {

//    lateinit var avaiblePuzzles:ArrayList<PuzzleCollectionItem>
    private lateinit var binding: ActivityPuzzleViewBinding
    private var puzzleId=1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPuzzleViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        puzzleId=Config.CURR_PUZZLE


        binding.tvPuzzleName.text="😎😎😎⚡Puzzle #${puzzleId}"


        var subName=""
        var exploringStatus=""
        if(currPuzzle.status=="explored") {
            subName="${currPuzzle.name}"
            exploringStatus="EXPLORED🏆"
        }
        else{
            subName="???"
            exploringStatus="explored ${(currPuzzle.player_items).size} / 9"
        }


        binding.tvSubName.text = subName
        binding.tvExploringStatus.text=exploringStatus



        var img_path = "puzzle_img/${currPuzzle.id}/1.png"

        try {
            val ims: InputStream = this.assets.open(img_path)
            val d = Drawable.createFromStream(ims, null)

//            val d = Drawable.createFromResourceStream(ims, null,opts)
//            binding.ivPuzzle.setImageResource(R.drawable.chest_5)
            binding.ivTest.setImageDrawable(d)
            binding.ivTest2.setImageDrawable(d)
            binding.ivTest3.setImageDrawable(d)
//            binding.ivTest.minimumHeight = DisplayMetrics.DENSITY_140

        } catch (ex: IOException) {
            return
        }

//        binding.pf1

        //adding to view




    }


}