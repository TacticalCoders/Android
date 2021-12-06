package com.example.fragmentsample

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.widget.Button
import com.example.fragmentsample.R

class FragmentA : Fragment() {

    var activityCallback: ButtonListener? = null

    interface ButtonListener {
        fun onButtonClick()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_a, container, false)
        val button: Button = rootView.findViewById(R.id.button)
        button.setOnClickListener {
            activityCallback?.onButtonClick()
        }
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            if (context is ButtonListener) {
                activityCallback = context
            }
        } catch (e:ClassCastException) {
            throw ClassCastException(context.toString()
                    + " must implement buttonListener")
        }
    }
}