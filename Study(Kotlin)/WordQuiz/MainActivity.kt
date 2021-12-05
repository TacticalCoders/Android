package com.example.wordquiz

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

const val EXTRA_CUR_INDEX = "com.example.wordquiz.extra_cur_index"

class MainActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by lazy {
        ViewModelProvider(this).get(WordViewModel::class.java)
    }

    private lateinit var wordTextView: TextView
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton
    private lateinit var nextButton:Button
    private lateinit var prevButton:Button
    private lateinit var hintButton: Button
    private lateinit var hintTextView: TextView
    private var hintReferred:Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordTextView = findViewById(R.id.wordTextView)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        radioButton4 = findViewById(R.id.radioButton4)
        nextButton = findViewById(R.id.nextButton)
        prevButton = findViewById(R.id.prevButton)
        hintButton = findViewById(R.id.hintButton)
        hintTextView = findViewById(R.id.hintTextView)


        updateWordQuiz()

        nextButton.setOnClickListener {
            wordViewModel.moveToNext()
            updateWordQuiz()
        }

        prevButton.setOnClickListener {
            wordViewModel.moveToPrevious()
            updateWordQuiz()
        }

        hintButton.setOnClickListener {
            val intent = HintActivity.newIntent(this@MainActivity, //인스턴스 없이 클래스 이름을 사용해 동반 객체의 멤버 메소드를 호출.
                wordViewModel.curIndex)
            //startActivity(intent)
            startForResult.launch(intent)
        }

        radioButton1.setOnClickListener{
            checkAnswer(1)
        }

        radioButton2.setOnClickListener{
            checkAnswer(2)
        }

        radioButton3.setOnClickListener{
            checkAnswer(3)
        }

        radioButton4.setOnClickListener{
            checkAnswer(4)
        }
    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult->
        if(result.resultCode == Activity.RESULT_OK) {
            hintReferred = result.data?.getBooleanExtra(EXTRA_HINT_SHOWN, false) ?: false // ?:는 좌항이 null인 경우에는 기본값 false를 반환.
            if (hintReferred) { //true인 경우.
                hintTextView.setText(R.string.hint_message)
            } else {
                hintTextView.text = ""
            }
        }
    }

    private fun updateWordQuiz() {
        wordTextView.text = wordViewModel.curQuestion
        radioButton1.text = wordViewModel.culNumber1
        radioButton2.text = wordViewModel.culNumber2
        radioButton3.text = wordViewModel.culNumber3
        radioButton4.text = wordViewModel.culNumber4

        radioButton1.isChecked = false
        radioButton2.isChecked = false
        radioButton3.isChecked = false
        radioButton4.isChecked = false
        hintReferred = false
        hintTextView.text = ""
    }

    private fun checkAnswer(userAns: Int){
        val correctAns = wordViewModel.curAnswer

        val message : String = if (userAns == correctAns){
            getString(R.string.right_ans_msg)
        } else{
            getString(R.string.wrong_ans_msg)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
