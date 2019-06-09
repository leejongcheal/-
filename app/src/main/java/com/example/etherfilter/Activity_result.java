package com.example.etherfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String addr = intent.getExtras().getString("Addr");
        // TODO addr주소 검색후 있으면 -> 결과창 보이기
        // TODO 없으면 알림표시후 뒷페이지로 나오기

    }
}
