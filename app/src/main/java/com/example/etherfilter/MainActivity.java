package com.example.etherfilter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText email_login;
    private EditText pwd_login;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 시작 함수로 여기에 전의 Intent내용 받아오고 뷰에 넣어주거나 변수에 저장해야함
        login = (Button) findViewById(R.id.login_button);
        email_login = (EditText) findViewById(R.id.text_email);
        pwd_login = (EditText) findViewById(R.id.text_password);
        firebaseAuth = firebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = email_login.getText().toString().trim();
                String pwd = pwd_login.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, email+"님 로그인", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, Activity_munu.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
//    /** Called when the user taps the Send button */
//    public void send_login(View view) {
//        // TODO 로그인 성공시 화면넘어가기 및 로그인 정보 넘기기
//        // Log.d("tag", "로그인 화면 눌러짐");
//        System.out.println("로그인");
//        Intent intent = new Intent(this, Activity_munu.class);
//        startActivity(intent);
//    }

    /** Called when the user taps the Send button */
    public void sign_up(View view) {
        // TODO 성공
        Intent intent = new Intent(this, Activity_account.class);
        startActivity(intent);
    }
}