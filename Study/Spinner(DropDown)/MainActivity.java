package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        tv_result = (TextView)findViewById(R.id.tv_result);

        //clicked리스너가 아닌 selected리스너를 사용해야 한다!
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_result.setText(parent.getItemAtPosition(position).toString()); //String으로 변환해줘야...
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}