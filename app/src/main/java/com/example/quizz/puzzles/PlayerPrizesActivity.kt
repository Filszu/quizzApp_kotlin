package com.example.quizz.puzzles

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.quizz.Config
import com.example.quizz.R
import com.example.quizz.ResultActivity
import com.example.quizz.databinding.ActivityPlayerPrizesBinding
import com.example.quizz.getJsonDataFromAsset
import com.example.quizz.puzzleView.PuzzleViewActivity
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

lateinit var currPuzzle:PuzzleCollectionItem
class PlayerPrizesActivity : AppCompatActivity() {


    lateinit var avaiblePuzzles:ArrayList<PuzzleCollectionItem>
    private lateinit var binding: ActivityPlayerPrizesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_prizes)

        binding = ActivityPlayerPrizesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        avaiblePuzzles = getAvailablePuzzles(this)
        createFromPuzzlesList()




    }


    private fun getAvailablePuzzles(applicationContext: Context):ArrayList<PuzzleCollectionItem>{


        val jsonFileString = getJsonDataFromAsset(applicationContext, "prizes/puzzles_list/puzzle.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val gson = Gson()



        return gson.fromJson(jsonFileString, PuzzleCollection::class.java)


    }

    private fun createFromPuzzlesList(){
        for(el in avaiblePuzzles) {
            addPuzzleView(el)
        }
    }


    private fun addPuzzleView(item:PuzzleCollectionItem){


        //create based on template
        val puzzleItemView: View = layoutInflater.inflate(R.layout.available_quizz_item_layout, null, false)


        var editText: TextView = puzzleItemView.findViewById(R.id.tv_quizzName)



        val cardView: CardView = puzzleItemView.findViewById(R.id.cv_quizzItem)

        cardView.setOnClickListener {

            Config.CURR_PUZZLE= item.id
            currPuzzle=item

            val intent = Intent(this, PuzzleViewActivity::class.java)

            startActivity(intent)
        }


        val ivImg: ImageView = puzzleItemView.findViewById(R.id.img)




        var img_path="puzzle_img/qMark.png";
        var puzzleName="???unexplored???";

//        discoverd
        if(item.status=="explored")
        {
//            "#${item.id} | "
            puzzleName = item.name
            img_path = "puzzle_img/${item.id}/img.png"
        }

        editText.text = puzzleName
        try {
            val ims: InputStream = this.assets.open(img_path)
            val d = Drawable.createFromStream(ims, null)

//            val d = Drawable.createFromResourceStream(ims, null,opts)
//            binding.ivPuzzle.setImageResource(R.drawable.chest_5)
            ivImg.setImageDrawable(d)
            ivImg.minimumHeight = DisplayMetrics.DENSITY_XXHIGH

        } catch (ex: IOException) {
            return
        }

        //adding to view
        binding.quizListContainer.addView(puzzleItemView)


    }
}


