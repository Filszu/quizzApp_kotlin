package com.example.quizz.lootbox

import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.quizz.R
import com.example.quizz.databinding.FragmentLootBoxBinding

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


        binding.ivChest.setOnClickListener{
            binding.ivChest.setBackgroundResource(R.drawable.animation_list)

            var chestAnim :AnimationDrawable = binding.ivChest.background as AnimationDrawable

            chestAnim.start()

            var fadeIn: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
            binding.ivPuzzle.startAnimation(fadeIn)
        }








    }

}