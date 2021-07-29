package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_dialog;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        tv_result = (TextView)findViewById(R.id.tv_result);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dialog 생성하기
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                //기본적으로 Dialog에는 아이콘, 제목, 메세지를 설정해 준다.
                ad.setIcon(R.mipmap.ic_launcher); //기본 제공 아이콘 사용.
                ad.setTitle("제목");
                ad.setMessage("강병하는 존잘입니까?");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et); // Dialog에 EditText추가.

                //Dialog에는 긍정 버튼과 부정 버튼이 있음을 알 수 있다.

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = et.getText().toString();
                        tv_result.setText(result);
                        dialog.dismiss();
                    }
                });

               ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });

               ad.show(); //show()를 꼭 해줘야 함.
            }
        });
    }
}