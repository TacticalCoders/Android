package com.example.finallastpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

const val EXTRA_MESSAGE = "com.example.intentsample.EXTRA_MESSAGE"
const val RETURN_MESSAGE = "com.example.intentsample.RETURN_MESSAGE"

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            var subIntent = Intent(this, SubActivity::class.java)
            val str = editText.text.toString()
            subIntent.putExtra(EXTRA_MESSAGE, str)
            startForResult.launch((subIntent))
        }
    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data != null) {
                val extras:Bundle? = result.data?.extras
                val returnString = extras?.getString(RETURN_MESSAGE) ?: ""
                editText.setText(returnString)
            }
        }
    }
}
