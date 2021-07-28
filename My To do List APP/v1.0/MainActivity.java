package com.example.mytodolistapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;

    private Button bt_add;
    private String str = "";

    private ListView listView;
    private List<String> listdata;
    private ArrayAdapter<String> adapter;

    public static final String PREFS_NAME = "database";
    String value;

    //최초 실행시
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_add = (Button) findViewById(R.id.bt_add);

        listdata = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listdata);

        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adapter); //연결.


        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,0);

        int k = 0;
        while ( sharedPreferences.contains(String.valueOf(k)) ){
            value = sharedPreferences.getString(String.valueOf(k),"");
            listdata.add(value);
            adapter.notifyDataSetChanged();
            k++;
        }

        //리스트뷰 각 항목 이벤트 처리
        listView.setOnItemClickListener(listener);
        //리스너는 리스트뷰 단위로 적용할 수 있음을 알 수 있다.
        //oncreate바깥에 실제로 listner 객체를 생성해줘여 한다.

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listdata.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                //어떤 구성요소(컴포넌트)간의 연결인지를 인자에 넣어 지정.
                startActivityForResult(intent, GET_STRING);
                //나중에 실행되는 액티비티로부터 정보를 받아와야 하는 경우에는 startActivityForResult를 사용한다.
            }
        });

    }

    //activity_add 액티비티 실행후 메인 액티비티로 다시 돌아왔을 때
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                listdata.add(data.getStringExtra("INPUT_TEXT"));
                adapter.notifyDataSetChanged();
            }
        }
    }

    //앱을 종료했을 때
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(int i=0; i < listdata.size(); i++){
            editor.putString(String.valueOf(i),listdata.get(i));
            //shared레퍼런스에 순서대로 문자열을 저장. "0" - "운동하기"
            editor.commit();
        }
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

        //첫번째 파라미터 : 클릭된 아이템을 보여주고 있는 AdapterView 객체(여기서는 ListView객체)
        //두번째 파라미터 : 클릭된 아이템 뷰
        //세번째 파라미터 : 클릭된 아이템의 위치(ListView이 첫번째 아이템(가장위쪽)부터 차례대로 0,1,2,3.....)
        //네번재 파리미터 : 클릭된 아이템의 아이디(특별한 설정이 없다면 세번째 파라이터인 position과 같은 값)
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            CheckedTextView check = (CheckedTextView)view;
            check.setChecked(!check.isChecked());

        }
    };
}

//앱을 종료한 후에도 리스트의 데이터를 보존하기 위한 작업. -> sharedPreferences로 해결.

/*
    1. 아이템 개별 항목 이벤트 처리
            - 짧게 한 번 터치시 체크박스 체크 구현.
            - 길게 터치시 메뉴 화면나오면서 삭제, 수정할 수 있도록 함.

    2. 체크박스 체크시 노란 색으로 체크 표시 구현하기
    3. 12시가 되면 모두 초기화되게 하기(안드로이드상 시간 받아서 해결?)
    4. 일어나는 시간을 입력받아 기상 후 첫 핸드폰 화면을 켰을 때, to do list 앱 실행하게 하기 (10분)
 */

