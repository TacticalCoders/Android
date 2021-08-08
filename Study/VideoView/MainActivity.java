package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private String videoURL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);

        mediaController = new MediaController(this); //비디오뷰의 재생, 일시정지 등을 할 수 있는 컨트롤바 생성.
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse(videoURL);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri); //비디오 뷰의 주소를 설정.
        videoView.start();
    }
}