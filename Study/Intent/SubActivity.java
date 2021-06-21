package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent(); //SubActivity실행시 또 다른 인텐트 변수로 넘어온 인텐트를 받아옴.
        String str = intent.getStringExtra("str"); //인텐트에는 부가정보(str)이 담겨있으므로 이를 받아옴.

        tv_sub.setText(str);

    }
}