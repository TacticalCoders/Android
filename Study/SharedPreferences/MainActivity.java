//앱을 종료(Ex뒤로가기)했을 때 데이터를 유지하고 싶을 때 SharedPreference를 사용한다.
package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        String value = sharedPreferences.getString("kang","");//값을 꺼내오는 것이기 때문에 두번 째 인자는 빈칸으로.
        //이를 통해 공유하고 있는 shared변수에 저장된 값을 불러온다.
        et_save.setText(value);
        //sharedPreferences에 있는 값을 다시 설정해줌.

    }

    //앱 종료(메인 엑티비티에서 벗어났을 때)시에 실행되는 실행 주기.
    @Override
    protected void onDestroy() { //ctrl+o 로 쉽게 메소드를 찾을 수 있다.
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        //이 코드로 인해 shared라는 스트링 변수를 공통으로 참조하게 됨.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //이 스트링 변수를 수정하기 위한 에디터 객체 생성.
        String value = et_save.getText().toString();
        //메인 액티비티에 있는 데이터를 임시로 저장함.
        editor.putString("kang",value); //kang은 키일 뿐 저장되는 값이 아니다.
        //에디터에다가 수정하려는 값 추가. -> shared가 입력된 값으로 변경됨.
        editor.commit(); //데이터베이스에 영구저장.
    }
}