package com.example.quizz.sounds

import android.content.Context
import android.media.MediaPlayer
import android.widget.Toast
import com.example.quizz.R

var avaibleSND = mutableListOf(R.raw.chest_opening,R.raw.open,R.raw.claps)

fun playSND(sndId:Int,context:Context?){
    try{
        val snd = MediaPlayer.create(context, avaibleSND[sndId])
        snd.start()
    }
    catch(e:Exception){
        val snd = MediaPlayer.create(context, avaibleSND[0])
        snd.start()
    }

}

fun openChestSound(context:Context?){
    val nMax= avaibleSND.size-1
    val n = (0..nMax).random()

    Toast.makeText(context,
        "teid $n", Toast.LENGTH_SHORT).show()

    playSND(n,context)

}