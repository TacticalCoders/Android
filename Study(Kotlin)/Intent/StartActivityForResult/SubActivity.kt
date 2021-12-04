package com.example.intentsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)


        val editText:EditText = findViewById(R.id.editText)
        val extras = intent.extras ?: null
        if(intent.hasExtra(EXTRA_MESSAGE)){
            val message = extras?.getString(EXTRA_MESSAGE)
            editText.setText(message)
        }


        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val str = editText.text.toString()
            val data = Intent()
            data.putExtra(RETURN_MESSAGE, str)
            setResult(Activity.RESULT_OK, data) //결과를 bundle객체와 함께 전달.
            finish()
        }
    }
}
