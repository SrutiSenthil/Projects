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

public class ForgetPasswordActivity extends AppCompatActivity {
    Button submitb;
    EditText emailtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        submitb = (Button)findViewById(R.id.submit);
        emailtxt = (EditText)findViewById(R.id.emailid);


        submitb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = emailtxt.getText().toString();
                int otp = (int) (Math.random() * 1000);
                String[] TO = {id};
                //String[] CC = {""};
                Intent emailIntent = new Intent();

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
               // emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bus Tracking App :recover your account ");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "This OTP must be entered norder to retrive your account OTP = "+otp);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Toast.makeText(getApplicationContext(),"mail is sent", Toast.LENGTH_SHORT).show();
                } catch (android.content.ActivityNotFoundException ex) {

                    Toast.makeText(ForgetPasswordActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
