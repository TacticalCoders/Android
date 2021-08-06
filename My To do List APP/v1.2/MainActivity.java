package com.example.recyclerviewex2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;

    private ArrayList<MainData> arrayList;
    private MainAdaptor mainAdaptor;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; //이건 왜 필요한 것???

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this); //리니어레이아웃매니저 생성 후 리사이클 뷰에 달아줌.
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        mainAdaptor = new MainAdaptor(arrayList);
        recyclerView.setAdapter(mainAdaptor);

        ImageButton btn_add = (ImageButton) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,GET_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                MainData mainData = new MainData(R.mipmap.ic_launcher,data.getStringExtra("INPUT_TEXT"));
                arrayList.add(mainData);
                mainAdaptor.notifyDataSetChanged();
            }
        }
    }
}