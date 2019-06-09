package com.example.etherfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_munu extends AppCompatActivity {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munu);
    }

    /** Called when the user taps the Send button */
    public void search_addr(View view) {
        // TODO [규진]주소 검색 화면으로 보내기
        Intent intent = new Intent(this, Activity_search.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void sign_out(View view) {
        mAuth = FirebaseAuth.getInstance();
        if(user != null){
            String  user_email = user.getEmail();
            Toast.makeText(Activity_munu.this, user_email+"님 sign out", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(Activity_munu.this, "sign 실패", Toast.LENGTH_SHORT).show();
        }
        // TODO 사인아웃화면으로 로그인된내용 지우고 메인으로 보내기

    }

    /** Called when the user taps the Send button */
    public void report(View view) {
        // TODO 리포트 화면으로 보내기 후에 필요하다면 로그인(이메일)내용 보내주기
        Intent intent = new Intent(this, Activity_report.class);
        startActivity(intent);
    }
}
