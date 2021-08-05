package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup rg_gender;
    private RadioButton rb_man, rb_women;
    private Button btn_result;
    private String str_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
        rb_man = findViewById(R.id.rb_man);
        rb_man = findViewById(R.id.rb_women);
        btn_result = findViewById(R.id.btn_result);
        
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if( checkedId == R.id.rb_man){
                    Toast.makeText(MainActivity.this,"남자가 선택되었음",Toast.LENGTH_LONG).show();
                    str_result = rb_man.getText().toString();
                }
                else if( checkedId == R.id.rb_women){
                    Toast.makeText(MainActivity.this,"여자가 선택되었음",Toast.LENGTH_LONG).show();
                    str_result = rb_women.getText().toString();
                }
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str_result != null){
                    Toast.makeText(MainActivity.this,str_result,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"성별을 선택해주세요",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}