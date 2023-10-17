package com.example.fourpicturesonewords.model

import android.content.Context
import android.media.MediaPlayer
import com.example.fourpicturesonewords.R

object BackMusic {

    var mediaPlayer = MediaPlayer()

    fun create(context: Context){
        mediaPlayer = MediaPlayer.create(context, R.raw.back_music)
        mediaPlayer.start()
    }
}