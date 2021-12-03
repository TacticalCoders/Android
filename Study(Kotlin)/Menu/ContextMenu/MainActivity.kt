package com.example.menusample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView;
    private lateinit var textView2 : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        registerForContextMenu(textView) //위젯에 contextMenu를 등록함.
        registerForContextMenu(textView2)
    }

    override fun onCreateContextMenu(  // 컨텍스트 메뉴가 최초로 한번만 호출되는 콜백 메서드
        menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) { //여기서 view는 롱클릭한 위젯
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v == textView) menuInflater.inflate(R.menu.menu_main, menu)
        if(v == textView2) menuInflater.inflate(R.menu.menu_main_kor,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_yellow -> {
                textView.setBackgroundColor(android.graphics.Color.YELLOW)
                true
            }
            R.id.menu_blue -> {
                textView.setBackgroundColor(android.graphics.Color.BLUE)
                true
            }
            R.id.menu_green -> {
                textView.setBackgroundColor(android.graphics.Color.GREEN)
                true
            }
            R.id.menu_yellow_ko -> {
                textView2.setBackgroundColor(android.graphics.Color.YELLOW)
                true
            }
            R.id.menu_blue_ko -> {
                textView2.setBackgroundColor(android.graphics.Color.BLUE)
                true
            }
            R.id.menu_green_ko -> {
                textView2.setBackgroundColor(android.graphics.Color.GREEN)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
