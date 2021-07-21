package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        List<String> data = new ArrayList<>(); //배열 안에다가 스트링 형태로 넣겠다.



        //ListView와 List를 연결해주는 과정
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        //this는 현재의 액티비티(MainActivity)를 말함.
        list.setAdapter(adapter); //연결.


        //Item을 추가하는 과정.
        data.add("홍드로이드");
        data.add("안드로이드");
        data.add("강드로이드");

        adapter.notifyDataSetChanged(); //현재 상태를 저장하겠다.



    }
}