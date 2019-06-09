package com.example.etherfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity_search extends AppCompatActivity {
    EditText addr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    //TODO 일단은 주소를 입력받아서 대문자로 변환후 결과창으로 넘긴다.
    //TODO 결과창에서 주소에 대해서 검색후 있으면 그창에 결과를 보여주고 없으면 알림메세지와 함께 search 페이지로 돌아오기
    public void Search(View view) {
        addr = findViewById(R.id.result_addr);
        String address = addr.getText().toString().trim().toUpperCase();

        Intent intent = new Intent(this, Activity_result.class);
        intent.putExtra("Addr",address);
        startActivity(intent);

    }
}
