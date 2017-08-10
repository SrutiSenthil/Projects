package com.example.sri.bustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Option extends AppCompatActivity {

    Button loginb,registerb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        //on clicking login button
        loginb = (Button)findViewById(R.id.button);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Option.this,LoginActivity.class);
                startActivity(i);
            }
        });
        // on clicking register button
        registerb = (Button)findViewById(R.id.button2);
        registerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Option.this,CandidateActivity.class);
                startActivity(i);
            }
        });



    }
}
