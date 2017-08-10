package com.example.sri.bustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CandidateActivity extends AppCompatActivity {

    Button busdriverregb,studentregb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        //on clicking busdriverregb
        busdriverregb = (Button)findViewById(R.id.button9);
        busdriverregb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CandidateActivity.this,RegisterBusDriverActivity.class);
                startActivity(i);
            }
        });

        //on clicking studedntregb
        studentregb = (Button)findViewById(R.id.button10);
        studentregb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CandidateActivity.this,RegisterStudentActivity.class);
                startActivity(i);
            }
        });

    }
}
