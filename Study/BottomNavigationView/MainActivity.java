package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //하단바
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Home home;
    private ToDoList toDoList;
    private Checked checked;
    private Calendar calendar;
    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.todolist:
                        setFrag(1);
                        break;
                    case R.id.checked:
                        setFrag(2);
                        break;
                    case R.id.calendar:
                        setFrag(3);
                        break;
                    case R.id.setting:
                        setFrag(4);
                        break;
                }
                return true; //true로 바꿔줌.
            }
        });

        home = new Home();
        toDoList = new ToDoList();
        checked = new Checked();
        calendar = new Calendar();
        setting = new Setting();

        setFrag(0); //앱 처음시작시 표시할 프래그먼트 지정.



    }
    // 프래그먼트 교체가 일어나는 실행문.
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame,home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,toDoList);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,checked);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,calendar);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,setting);
                ft.commit();
                break;
        }
    }
}