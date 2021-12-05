package com.example.wordquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val EXTRA_HINT_SHOWN = "com.example.wordquiz.extra_hint_shown"

class HintActivity : AppCompatActivity() {

    private val wordDictViewModel: WordDictViewModel by lazy {
        ViewModelProvider(this).get(WordDictViewModel::class.java)
    }

    companion object { //동반 객체의 멤버 메소드를 호출.
        fun newIntent(packageContext: Context, curDictIndex: Int): Intent { //생성자를 사용해 클래스 인스턴스(instance)를 생성할 필요가 없음.
            return Intent(packageContext, HintActivity::class.java).apply {
                putExtra(EXTRA_CUR_INDEX, curDictIndex)
            }
        }
    }

    private lateinit var word1TextView: TextView
    private lateinit var word1MeaningTextView: TextView
    private lateinit var word2TextView: TextView
    private lateinit var word2MeaningTextView: TextView
    private lateinit var word3TextView: TextView
    private lateinit var word3MeaningTextView: TextView
    private lateinit var word4TextView: TextView
    private lateinit var word4MeaningTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)

        word1TextView = findViewById(R.id.word1TextView)
        word1MeaningTextView = findViewById(R.id.word1MeaningTextView)
        word2TextView = findViewById(R.id.word2TextView)
        word2MeaningTextView = findViewById(R.id.word2MeaningTextView)
        word3TextView = findViewById(R.id.word3TextView)
        word3MeaningTextView = findViewById(R.id.word3MeaningTextView)
        word4TextView = findViewById(R.id.word4TextView)
        word4MeaningTextView = findViewById(R.id.word4MeaningTextView)
        backButton = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            val data = Intent().apply {
                putExtra(EXTRA_HINT_SHOWN, true)
            }
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        wordDictViewModel.curIndexDict = intent.getIntExtra(EXTRA_CUR_INDEX, 0)
        updateWordDict()
    }

    private fun updateWordDict() {
        word1TextView.text = wordDictViewModel.curWord1
        word1MeaningTextView.text = wordDictViewModel.curWord1Meaning
        word2TextView.text = wordDictViewModel.curWord2
        word2MeaningTextView.text = wordDictViewModel.curWord2Meaning
        word3TextView.text = wordDictViewModel.curWord3
        word3MeaningTextView.text = wordDictViewModel.curWord3Meaning
        word4TextView.text = wordDictViewModel.curWord4
        word4MeaningTextView.text = wordDictViewModel.curWord4Meaning
    }
}
