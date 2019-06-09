package com.example.etherfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

public class Activity_report extends AppCompatActivity {
    EditText addr;
    EditText reason;
    @IgnoreExtraProperties
    public class FirebasePost {
        public String Addr;
        public String Informer;
        public String Plaform;
        public String Reference;
        public String State;
        public String Type;

        public FirebasePost(){
            // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
        }

        public FirebasePost(String Addr, String informer,String Plaform, String Reference, String State, String Type) {
            this.Addr = Addr;
            this.Informer = informer;
            this.Plaform = Plaform;
            this.Reference = Reference;
            this.State = State;
            this.Type = Type;
        }

        @Exclude
        public Map<String, Object> toMap() {
            HashMap<String, Object> result = new HashMap<>();
            result.put("Addr", Addr);
            result.put("Informer", Informer);
            result.put("Plaform", Plaform);
            result.put("Referenc",Reference);
            result.put("State", State);
            result.put("Type",Type);
            return result;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    public void send_report(View view) {
        addr = findViewById(R.id.result_addr);
        reason = findViewById(R.id.Report_Reason);
        String addrs = addr.getText().toString().trim();
        String reasons = reason.getText().toString().trim();
        if (addrs.length() == 0) {
            Toast.makeText(Activity_report.this, "address 입력하세요", Toast.LENGTH_SHORT).show();
            addr.requestFocus();
            return;
        }
        if (reasons.length() == 0) {
            Toast.makeText(Activity_report.this, "reason 입력하세요", Toast.LENGTH_SHORT).show();
            reason.requestFocus();
            return;
        }
        // TODO  주소(대문자로 변환[앞에 숫자 0과 X후에 숫자와 영어 혼합])와 제출자(유저 이메일)
        // Addr="입력 받은 주소_대문자로 변환",State = NOT APPROVED,Type[3가지중 하나 선택],Plaform="ETH",Informer="유저 이메일",Reference="입력받은 reason"
        Toast.makeText(Activity_report.this, "Report 제출 성공", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Activity_munu.class);
        startActivity(intent);
    }
   // public void click_(View view)
   // public void send_report(View view)
    //public void send_report(View view)
}
