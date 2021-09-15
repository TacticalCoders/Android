package edu.ourincheon.myapplication

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bgId: ConstraintLayout = findViewById(R.id.screen_background)
        //val bgColor = resources.getColor(R.color.color_background);
        val bgColor = ContextCompat.getColor( this, R.color.color_background)
        bgId.setBackgroundColor(bgColor)
    }

    fun onBtnClicked(view: View) {

        val dollars: EditText = findViewById(R.id.dollarEditText)
        var tv: TextView = findViewById(R.id.textView)

        var textColor = ContextCompat.getColor(this, R.color.color_textview)
        val textSize = resources.getDimension(R.dimen.text_size)

        if(dollars.text.isNotEmpty()) {
            tv.setTextColor(textColor);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,textSize)

            var dollorValue = dollars.text.toString().toInt()
            var wonValue = dollorValue * 1136;
            tv.text = wonValue.toString() +  " 원"
        }else{
            tv.text = "No value"
        }

        //tv.text = "안녕, 안드로이드!" // 코틀린의 장점->속성을 직접 지정가능.
        //tv.setText("안녕, 안드로이드!") Java
    }


}
