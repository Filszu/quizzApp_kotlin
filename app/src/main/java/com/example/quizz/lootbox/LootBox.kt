package com.example.quizz.lootbox

import android.R.drawable
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizz.Config.CAN_OPEN_CHEST
import com.example.quizz.R
import com.example.quizz.ResultActivity
import com.example.quizz.databinding.FragmentLootBoxBinding
import com.example.quizz.puzzles.PlayerPrizesActivity
import com.example.quizz.sounds.openChestSound
import java.io.IOException
import java.io.InputStream


class LootBox : Fragment() {

    private var _binding:FragmentLootBoxBinding? =null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = LootBox()
    }

    private lateinit var viewModel: LootBoxViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLootBoxBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LootBoxViewModel::class.java)




        if(CAN_OPEN_CHEST==true) {
            keysStatus(1)
        }else
        {
            keysStatus(0)
        }



            binding.btnGoToYourCollection.setOnClickListener{


                val intent = Intent(activity, PlayerPrizesActivity::class.java)

                startActivity(intent)

            }
            binding.ivChest.setOnClickListener {

                if(CAN_OPEN_CHEST==true) {

                   openRewardChest()
                    keysStatus(0)



                }
                else{
                    Toast.makeText(context,
                        "you must score 100% or watch an ad to get your free key", Toast.LENGTH_SHORT).show()
                }
            }

//        get keys
        binding.btnOpenChest.setOnClickListener {

            if(CAN_OPEN_CHEST==false){

                keysStatus(1)

                Toast.makeText(context,
                    "ads loading...", Toast.LENGTH_SHORT).show()

                CAN_OPEN_CHEST=true

            }



        }








    }


    private fun openRewardChest(){
        CAN_OPEN_CHEST=false

        binding.ivChest.setBackgroundResource(R.drawable.animation_list)

        var chestAnim: AnimationDrawable = binding.ivChest.background as AnimationDrawable

        chestAnim.start()


        randCard()
        getPuzzleImage()


        var fadeIn: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_in2)
        openChestSound(context)




        //            val `is` = requireContext().assets.open("dora.txt")


        showReward(fadeIn)
    }

    private fun showReward(anim:Animation){

        binding.ivPuzzle.startAnimation(anim)
    }

    private fun showButtons(anim:Animation){

    }

    fun getPuzzleImage(){



//        val img_src="row-1-column-3.png"
        try {

//            val opts: BitmapFactory.Options = BitmapFactory.Options()
//            opts.inDensity = DisplayMetrics.DENSITY_HIGH

            val ims: InputStream = requireContext().assets.open("puzzle_img/$prize_card_set/$prize_card_img_id.png")
            val d = Drawable.createFromStream(ims, null)

//            val d = Drawable.createFromResourceStream(ims, null,opts)
//            binding.ivPuzzle.setImageResource(R.drawable.chest_5)
            binding.ivPuzzle.setImageDrawable(d)
            binding.ivPuzzle.minimumHeight = DisplayMetrics.DENSITY_XXHIGH

        } catch (ex: IOException) {
            return
        }
    }

    private fun keysStatus(status: Int) {

        var msg=""
        if(status==1) {
            msg ="you have 1 free unlock key🗝🔐🔑"
        }
        else if(status==0){
            msg="open chest\uD83C\uDFAC"
        }

        binding.btnOpenChest.text = msg

    }

}