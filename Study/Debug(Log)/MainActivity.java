package com.example.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String kang = "강병하";

        //Q.이걸 왜 하는가?

        Log.e("MainActivity",kang);  //이 앱이 실행이 될 때, 로그를 출력하라.
       //e는 error의 약자이다. 보통 e 나 d로 출력한다.

        int a = 10;
        Log.e("MainActivity",String.valueOf(a));

    }
}
