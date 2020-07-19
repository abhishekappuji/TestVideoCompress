package com.example.compressvideo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {
    var simpleVideoView: VideoView? = null
    var textView: TextView? = null
    var mediaControls: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)



        //val abc: Bundle  ?= intent.extras
        //val abcd  =abc!!.getString("path")
        //abhi.text=abc.toString()
        //val xyz:Uri= Uri.parse(abcd)
        simpleVideoView=findViewById(R.id.play) as VideoView
        textView=findViewById(R.id.compress) as TextView
        mediaControls = MediaController(this)
        mediaControls!!.setAnchorView(this.simpleVideoView)
        simpleVideoView!!.setMediaController(mediaControls)
        //abhi.text=intent.getStringExtra("path")
      play.setVideoURI(Uri.parse(intent.getStringExtra("path")))

        compress.setOnClickListener(){
            compressVideo()
        }
    }
    fun compressVideo(){

    }
}