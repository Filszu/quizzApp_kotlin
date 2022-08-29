package com.example.quizz.lootbox

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizz.R
import java.io.InputStream

class LootBoxViewModel : ViewModel() {
    private val puzzle_img_src= MutableLiveData<String>()
    private val puzzle_fragmnet_id = MutableLiveData<String>()
    private val puzzle_id = MutableLiveData<Int>()

    fun setPuzzleImg(filename:String){
        puzzle_img_src.value = filename
    }


    fun openImg() {

    }


}