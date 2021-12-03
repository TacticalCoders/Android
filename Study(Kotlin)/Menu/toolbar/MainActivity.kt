package com.example.menusample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu) //inflate = xml파일을 실제 화면에 나타내 주는 것.
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val layoutView: View = findViewById(R.id.layoutView) //배경색을 바꾸기 위해. (constraiont의 자료형은 View)
        return when(item.itemId){
            R.id.menu_apple -> {
                layoutView.setBackgroundColor(android.graphics.Color.RED)
                //item.isChecked = !item.isChecked
                item.isChecked = true
                showToast("사과")
                true
            }
            R.id.menu_grape -> {
                layoutView.setBackgroundColor(android.graphics.Color.MAGENTA)
                item.isChecked = !item.isChecked
                showToast("사과")
                true
            }
            R.id.menu_banana -> {
                layoutView.setBackgroundColor(android.graphics.Color.YELLOW)
                item.isChecked = !item.isChecked
                showToast("사과")
                true
            }
            else -> super.onOptionsItemSelected(item) //true 혹은 false 리턴
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
