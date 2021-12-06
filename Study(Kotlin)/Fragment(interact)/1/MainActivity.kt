package com.example.fragmentsample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
    FragmentA.ButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment_container = findViewById<FrameLayout>(R.id.fragment_container)
        if (fragment_container != null) {
            if (savedInstanceState != null) {
                return
            }
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .commit()
        }

        var buttonA = findViewById<Button>(R.id.buttonA)
        buttonA.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentA())
                .addToBackStack(null)
                .commit()
        }

        var buttonB = findViewById<Button>(R.id.buttonB)
        buttonB.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentB())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onButtonClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentB())
            .addToBackStack(null)
            .commit()
    }
}
