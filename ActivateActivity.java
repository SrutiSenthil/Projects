package com.example.sri.bustracking;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivateActivity extends AppCompatActivity {

    Button actib,sendb;
    EditText unameed,otped,emailed;

    double random = Math.random() * 1000 + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);

        unameed = (EditText)findViewById(R.id.unamede);
        otped = (EditText)findViewById(R.id.otpede);
        emailed = (EditText)findViewById(R.id.emailede);
        sendb = (Button) findViewById(R.id.sende);
        actib = (Button)findViewById(R.id.activateb);


        sendb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Send email", "");

                String TO = emailed.getText().toString();
                //String[] CC = {"xyz@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {TO});
                //emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "OTP for Bus Tracking app");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi! This is your one time password = \" + random + \" to activate your login in Bus Tracking app");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("email is sent...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ActivateActivity.this,"There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        actib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textotp = otped.getText().toString();
                String rstr = String.valueOf(random);
                if(rstr.equals(textotp))
                {
                    Toast.makeText(ActivateActivity.this,"Activated",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ActivateActivity.this,"Sorry please try again",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
