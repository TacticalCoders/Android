package com.example.mytodolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText input;
    private String str="";
    private Button bt_okay;
    private Button bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        input = (EditText) findViewById(R.id.input);
        bt_okay = (Button) findViewById(R.id.bt_okay);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = input.getText().toString();
                Intent intent =  new Intent(AddActivity.this,MainActivity.class);
                intent.putExtra("INPUT_TEXT",str);
                //정보를 찾기 위해서 Key값을 줘야 한다. 여기서 Key값은 INPUT_TEXT.
                setResult(RESULT_OK,intent);
                finish();
            }
        });


        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}