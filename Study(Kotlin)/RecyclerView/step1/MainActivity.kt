package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listItems = ArrayList<String>()
        /*listItems.add("Apple")
        listItems.add("grapes")
        listItems.add("banana")*/

        val list:Array<String> = resources.getStringArray(R.array.fruits)
        /*for (element in list)
            listItems.add(element)*/

        for(element in list)
            listItems.add(element)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) //요런 식으로 매니저를 달아줄 수 있다.

        val adapter = MyAdapter(listItems)
        recyclerView.adapter = adapter
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){ //하나의 뷰의 내부의 데이터를 홀딩하고 있음.
        var textView:TextView = view.findViewById(R.id.textView)
    }

    class MyAdapter(var list: ArrayList<String>) : RecyclerView.Adapter<MyViewHolder>(){ //generic type 이 <MyViewHolder>

        //ViewHolder '객체' 생성
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        //리스트(nameList)에 속한 item을 하나씩 가져 와 출력  한 개만 출력하는 것 같지만, 루프를 돌면서 반복 출력
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val name = list[position]
            holder.textView.text = name
        }

        override fun getItemCount(): Int = list.size
    }
}
