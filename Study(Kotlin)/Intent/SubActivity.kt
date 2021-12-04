package com.example.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val message:String? = intent.getStringExtra(EXTRA_MESSAGE) 
        val editText:EditText = findViewById(R.id.editText)
        editText.setText(message)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            finish()
        }
    }
}
