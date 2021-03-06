package com.example.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.intentsample.MESSAGE" //클래스 밖에서 const val로 선언했기 때문에 SubActivity에서도 접근 가능!

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val editText : EditText = findViewById(R.id.editText)

        button.setOnClickListener {
            var str = editText.text.toString()
            var subIntent = Intent(this, SubActivity::class.java)
            subIntent.putExtra(EXTRA_MESSAGE,str)
            startActivity(subIntent)
        }
    }
}
