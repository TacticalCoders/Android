package edu.ourincheon.myapplication

import androidx.appcompat.app.AppCompatActivity //androidx는 확장된 extension 라이브러리임.
import android.os.Bundle //오래전부터 사용해온 안드로이드 라이브러리

class MainActivity : AppCompatActivity() { // 자식 클래스 : 부모클래스 , ()가 있다는 것은 생성자를 호출한 것 cf)인터페이스 상속
    override fun onCreate(savedInstanceState: Bundle?) { //fun은 함수를 의미. AppCompatActivity의 onCreate를 재정의(오버라이드) 하겠다는 것. 인자는 설명 생략
        super.onCreate(savedInstanceState) // super, 즉 AppCompatActivity에 있는 onCreate를 호출한 것임.
        setContentView(R.layout.activity_main) //화면에 보일 레이아웃 리소스 지정.
    }
}
