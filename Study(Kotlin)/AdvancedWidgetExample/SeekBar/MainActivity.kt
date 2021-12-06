package com.example.advancedwidgetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import com.example.advancedwidgetexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(applicationContext,
                "점수:$rating", Toast.LENGTH_SHORT).show()
        }

        val textView: TextView = findViewById(R.id.textView)
        val seekBar: SeekBar = findViewById(R.id.seekBar)

        textView.text = "seek value = ${seekBar?.progress}"

        seekBar.setOnSeekBarChangeListener(
            object:SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?,
                                               progress: Int, fromUser: Boolean) {
                    textView.text = "seek value = $progress"
                    setBrightness(progress)
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?)  { }
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    textView.text = "seek value = ${seekBar?.progress}"
                }
            })
    }

    private fun setBrightness(b:Int) {
        var brightness = b
        if (brightness < 10) brightness = 10
        else if (brightness > 100) brightness = 100
        var lp = window.attributes
        lp.alpha = (brightness.toFloat())/ 100F
        lp.flags = (lp.flags or
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.attributes = lp
    }
}
