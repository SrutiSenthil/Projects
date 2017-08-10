package com.example.sri.bustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class StudentLoginFormActivity extends AppCompatActivity {
    TextView namet,unamet,colleget,emailt;
    Button listb,availableb,showb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_form);

        namet = (TextView)findViewById(R.id.nameval);
        unamet = (TextView)findViewById(R.id.unameval);
        colleget = (TextView)findViewById(R.id.collegeval);
        emailt = (TextView)findViewById(R.id.emailval);
        listb = (Button)findViewById(R.id.listbus);
        availableb = (Button)findViewById(R.id.availablebus);
        showb = (Button)findViewById(R.id.showallbus);

        String names = namet.getText().toString();
        String unames = unamet.getText().toString();
        String emails = emailt.getText().toString();
        String colleges = colleget.getText().toString();

        listb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(StudentLoginFormActivity.this,ListOfBusActivity.class);
                i.putExtra("bvalue","list1");
                startActivity(i);

            }
        });

        availableb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentLoginFormActivity.this,ListOfBusActivity.class);
                i.putExtra("bvalue","list2");
                startActivity(i);

            }
        });

        showb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentLoginFormActivity.this,MapsingleActivity.class);
            }
        });

    }
}
