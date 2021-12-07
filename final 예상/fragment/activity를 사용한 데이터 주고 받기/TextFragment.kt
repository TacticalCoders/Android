package com.example.finallastpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TextFragment : Fragment() {
    lateinit var textView: TextView
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_text, container, false)
        textView = rootView.findViewById(R.id.textView)
        return rootView
    }

    fun changeTextProperties(fontSize:Int, text:String) {
        textView.textSize = fontSize.toFloat()
        textView.text = text
    }
}