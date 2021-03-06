package com.example.sqliteex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

class dbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 2;

    public dbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contacts ( _id INTEGER PRIMARY KEY AUTOINCREMENT," + " name TEXT, tel TEXT);");

        for (int i = 0; i < 30; i++){
            db.execSQL("INSERT INTO contacts VALUES (null," + "'김철수 " + i + "'" +", '010-1234-100" + i +"');");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
}

public class MainActivity extends AppCompatActivity {

    dbHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new dbHelper(this);
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM contacts",null); //테이블의 모든 레코드를 커서 객체로 가져온다.

        startManagingCursor(cursor); //액티비티가 커서 객체를 관리하도록 함. 즉, 액티비티의 생애주기와 커서의 생애주기가 동일함.

        String[] from = {"name","tel"};
        int[] to = { android.R.id.text1, android.R.id.text2 };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to);
        //simple_list_item_2는 2개의 텍스트 뷰를 가지고 있어 첫번째 텍스트 뷰(android.R.id.text1)를 name과, 두번째 텍스트 뷰(android.R.id.text2)를 tel과 연결함.
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}