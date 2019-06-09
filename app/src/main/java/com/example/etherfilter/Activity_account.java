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

public class Activity_account extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private  EditText r;
    private   EditText p1;
    private   EditText p2;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        r = findViewById(R.id.account_email);
        p1 = findViewById(R.id.result_addr);
        p2 = findViewById(R.id.account_password2);
        btn = (Button)findViewById(R.id.button_cancel);
        firebaseAuth = FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = r.getText().toString().trim();
                String pwd = p1.getText().toString().trim();
                String pwd1 = p2.getText().toString().trim();
                if (r.getText().toString().length() == 0) {
                    Toast.makeText(Activity_account.this, "Email 입력하세요", Toast.LENGTH_SHORT).show();
                    r.requestFocus();
                    return;
                }
                if (p1.getText().toString().length() == 0) {
                    Toast.makeText(Activity_account.this, "Password 입력하세요", Toast.LENGTH_SHORT).show();
                    p1.requestFocus();
                    return;
                }
                if (p2.getText().toString().length() == 0) {
                    Toast.makeText(Activity_account.this, "Password Confirm 입력하세요", Toast.LENGTH_SHORT).show();
                    p2.requestFocus();
                    return;
                }
                if (!p1.getText().toString().equals(p2.getText().toString())) {
                    Toast.makeText(Activity_account.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    p1.setText("");
                    p2.setText("");
                    p1.requestFocus();
                    return;
                }// 유효성 검사 끝
                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Activity_account.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Activity_account.this, "등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Activity_account.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Activity_account.this, "등록 에러: 이메일 형태", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        });

    }

    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
