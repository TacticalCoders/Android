//MainData라는 클래스를 직접 작성한다. Alt + Insert키를 통해 메소드들을 간편하게 구현할 수 있다.
//MainData는 세개의 필드가 있으며, 이를 get하고 set하는 메소드들로 구성됨.
package com.example.recyclerview;

public class MainData {

    private int iv_profile;
    private String tv_name;
    private String tv_content;

    public MainData(int iv_profile, String tv_name, String tv_content) { //Alt + Insert > Constructor를 통해 쉽게 구현.
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
