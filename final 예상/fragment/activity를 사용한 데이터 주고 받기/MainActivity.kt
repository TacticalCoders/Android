package com.example.finallastpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), ToolbarFragment.ToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClick(fontSize: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(
            R.id.text_fragment) as TextFragment
        textFragment.changeTextProperties(fontSize, text)
    }
}
