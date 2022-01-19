package com.example.finallastpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val dataViewModel : DataViewModel by lazy {
        ViewModelProvider(this).get(DataViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val list = dataViewModel.dataLists
        var adapter = MyAdapter(list)
        recyclerView.adapter = adapter
    }

     class MyViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{ //하나의 뷰의 내부의 데이터를 홀딩하고 있음.

        private lateinit var data:Data
        val name:TextView = view.findViewById(R.id.tv_name)
        val msg:TextView = view.findViewById(R.id.tv_msg)
        val img:ImageView = view.findViewById(R.id.iv_profile)

        init {
            name.setOnClickListener(this)
        }

        fun bind(data:Data){
            this.data = data
            name.text = this.data.name
            msg.text = this.data.msg
            img.setImageResource(this.data.profile)
        }

        override fun onClick(v: View?) {
            Toast.makeText(v?.context,"${name.text} pressed",Toast.LENGTH_SHORT).show()
        }
    }

    class MyAdapter(var list: List<Data>) : RecyclerView.Adapter<MyViewHolder>(){ //generic type 이 <MyViewHolder>

        //ViewHolder '객체' 생성
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        //리스트(nameList)에 속한 item을 하나씩 가져 와 출력  한 개만 출력하는 것 같지만, 루프를 돌면서 반복 출력
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val data = list[position]
            holder.bind(data)
        }

        override fun getItemCount(): Int = list.size
    }
}
