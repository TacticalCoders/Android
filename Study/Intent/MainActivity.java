package com.example.intentex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test); //main에 있는 edittext와 연결

        btn_move = findViewById(R.id.btn_move); //main에 있는 button과 연결

        btn_move.setOnClickListener( new View.OnClickListener() { //리스터 생성.(익명 클래스 방식)
            @Override
            public void onClick(View v) { //버튼 터치 발생시
                str = et_test.getText().toString(); //스트링 형태로 변환해줘야 함.

                //Intent란 어플리케이션의 구성요소(컴포턴트)간에 작업 수행을 위한 정보를 전달하는 역할을 한다.
                Intent intent = new Intent(MainActivity.this, SubActivity.class); //어떤 구성요소(컴포넌트)간의 연결인지를 인자에 넣어 지정.
                intent.putExtra("str",str); //edittext에서 받아온 문자열을 인텐트에 정보 추가.
                startActivity(intent); //새로운 액티비티(SubActivity)를 화면에 띄움. 현재 인텐트에는 SubActivity가 지정되어 있으므로 화면에는 SubActivity가 뜨게 됨.
            }
        });
    }
}
