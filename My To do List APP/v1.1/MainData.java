package com.example.recyclerviewex2;

import android.widget.ImageButton;

public class MainData {  //하나의 아이템에 있는 데이터들을 정의함. 여기서는 이미지와, 문자열 두개의 필드가 필요.

    private int btn_check;
    private String tv_content;

    public MainData(int btn_check, String tv_content) {
        this.btn_check = btn_check;
        this.tv_content = tv_content;
    }

    public int getBtn_check() {
        return btn_check;
    }

    public void setBtn_check(int btn_check) {
        this.btn_check = btn_check;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
