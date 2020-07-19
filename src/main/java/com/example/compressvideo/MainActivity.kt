package com.example.compressvideo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 0

    lateinit var selectPath : Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectVideo.setOnClickListener {
            val intent =Intent(this,VideoActivity::class.java)
            fetchVideo()
            ///startActivity(intent)
        }
    }
    private fun fetchVideo() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "video/*"
        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {



        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            //playVideo.setVideoURI(data?.data)
            selectPath= data?.data!!
            //uriName.text=selectPath.toString()
            pass()

        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun pass(){
        val intent =Intent(this,VideoActivity::class.java)
        //intent.putExtra("path",selectPath)
        val selectedPath:String
        selectedPath=selectPath.toString()
        intent.putExtra("path",selectedPath)
        startActivity(intent)
    }
}