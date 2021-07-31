//스레드란 무엇인가?
//백그라운드 상태(홈버튼 클릭,,)에서 일련의 작업을 수행할 수 있게 해줌.
//이 앱에서는'스레드 시작'이라는 버튼을 누르게 되면 백그라운드 상에서 while문이 무한 반복되면서 handler를 통해 값을 전달하여 토스트 메시지를 띄우게 함.
package com.example.threadandhandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start,btn_stop;
    Thread thread;
    boolean isTread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스레드시작
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTread = true;
                thread = new Thread(){
                    public void run(){
                        while (isTread){
                            try {
                                sleep(5000); //5000 = 5초.
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage(0);
                        }
                    }
                };
                thread.start();
            }
        });

        //스레드종료.
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTread = false;
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(),"홍드로이드 강의",Toast.LENGTH_SHORT).show();
        }
    };
}