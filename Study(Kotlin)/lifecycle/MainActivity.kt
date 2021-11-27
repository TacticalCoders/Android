package com.example.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

private const val TAG = "Orientation"

class MainActivity : AppCompatActivity() {

    private lateinit var et_name:EditText
    private val KEY_NAME = "first_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_name = findViewById(R.id.et_name)

        if(savedInstanceState != null){
            var strName = savedInstanceState.getString(KEY_NAME)
            et_name.setText(strName)
        }
        Log.d(TAG,"onCreate() 호출됨")
    }

    override fun onSaveInstanceState(outState: Bundle) { //파라미터 하나짜리
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState() 호출됨")

        var strName:String = et_name.text.toString()
        outState.putString(KEY_NAME,strName)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG,"onRestoreInstanceState() 호출됨")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() 호출됨")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart() 호출됨")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() 호출됨")
    }
}
