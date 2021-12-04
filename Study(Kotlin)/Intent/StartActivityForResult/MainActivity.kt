package com.example.intentsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

const val EXTRA_MESSAGE = "com.example.intentsample.EXTRA_MESSAGE"
const val RETURN_MESSAGE = "com.example.intentsample.RETURN_MESSAGE"

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            var str = editText.text.toString()
            var subIntent = Intent(this, SubActivity::class.java)
            subIntent.putExtra(EXTRA_MESSAGE,str)
            startForResult.launch((subIntent)) //결과를 돌려받기 위한 Activity 호출!
        }
    }

    private val startForResult = registerForActivityResult( // 결과를 돌려받았을 때 처리할 메소드.
        ActivityResultContracts.StartActivityForResult() )
    { result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK)
            if(result.data != null){ // result.data는 intent 객체를 가리킴.
                val extras:Bundle? = result.data?.extras
                val returnString = extras?.getString(RETURN_MESSAGE) ?: ""
                editText.setText(returnString)
            }
    }
}
