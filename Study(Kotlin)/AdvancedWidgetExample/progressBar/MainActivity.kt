package com.example.advancedwidgetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText: EditText = findViewById(R.id.editText)
        val progressBar:ProgressBar = findViewById(R.id.progressBar)
        progressBar.progress = 0

        val button:Button = findViewById(R.id.button)
        button.setOnClickListener {
            var pval = convertInt(editText.text.toString().trim())
            if (pval in 1..100)
                progressBar.progress = pval
            else {
                progressBar.progress = 0
                Toast.makeText(this, "값 설정 에러: $pval",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun convertInt(s:String):Int {
        return Integer.parseInt(s)
    }
}
