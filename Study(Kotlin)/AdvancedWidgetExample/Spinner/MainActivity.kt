package com.example.advancedwidgetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //데이터와 스피너를 어댑터를 통해 연결하는 과정.
        val planets = resources.getStringArray(R.array.planets_array) //배열 리소스를 가지고 있는 변수.
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, planets
        ) //스피너의 디자인과 스피너의 리소스(planets)를 지정.
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter //스피너에 어댑터 연결.

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.onItemSelectedListener = //스피너 이벤트처리.
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ) {
                    var planet = parent?.getItemAtPosition(position).toString()
                    Toast.makeText(
                        parent?.context,
                        "선택된 행성은 $planet",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        //잠깐! 람다식 확장 함수 also()

       /* object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                var planet = parent?.getItemAtPosition(position).toString()
                Toast.makeText(parent?.context,
                    "선택된 행성은 $planet",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }.also { spinner.onItemSelectedListener = it }
        */

        //직접 인자로 지정하는 법.
        /*
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        val spinner:Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter
        */
    }
}
