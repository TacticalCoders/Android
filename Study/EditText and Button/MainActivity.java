package com.example.edittextex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_name; //단순히 버튼을 가리키는 레퍼런스 변수
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //앱 실행시 처음으로 동작되는 실행주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name); //실제 xml에 있는 EditText를 레퍼런스 변수에 연결한 것.
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() { //익명클래스로 바로 리스너 생성 후 연결함.
            @Override
            public void onClick(View v) { //버튼에 클릭 이벤트 발생시 처리할 문장.
                et_name.setText("다시 입력해주세요...");
            }
        });
    }
}