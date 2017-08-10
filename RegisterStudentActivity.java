package com.example.sri.bustracking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RegisterStudentActivity extends AppCompatActivity {
    Button registerb,cancelb;
    EditText name , uname , pass , email , college;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        name = (EditText)findViewById(R.id.studname);
        uname = (EditText)findViewById(R.id.studuname);
        pass = (EditText)findViewById(R.id.studpass);
        email = (EditText)findViewById(R.id.studemail);
        college = (EditText)findViewById(R.id.studcollge);

        registerb = (Button)findViewById(R.id.regstud);
        registerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent(RegisterStudentActivity.this,)
                String names = name.getText().toString();
                String unames = uname.getText().toString();
                String passs = pass.getText().toString();
                String emails = email.getText().toString();
                String colleges = college.getText().toString();

                StudentReg(names,unames,passs,emails,colleges);
            }
        });
        cancelb = (Button)findViewById(R.id.cancelstud);
        cancelb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterStudentActivity.this,Option.class);
                startActivity(i);
            }
        });

    }

    private void StudentReg(String names, String unames, String passs, String emails, String colleges) {
        class Insert extends AsyncTask<String,Void,String>{

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(RegisterStudentActivity.this,"Loading","Please Wait");
                super.onPreExecute();

            }


            @Override
            protected String doInBackground(String... strings) {

                String a = strings[0];
                String b = strings[1];
                String c = strings[2];
                String d = strings[3];
                String e = strings[4];
                List<NameValuePair> nameValuePairs = new ArrayList<>();
                nameValuePairs.add(new BasicNameValuePair("name",a));
                nameValuePairs.add(new BasicNameValuePair("username",b));
                nameValuePairs.add(new BasicNameValuePair("password",c));
                nameValuePairs.add(new BasicNameValuePair("email",d));
                nameValuePairs.add(new BasicNameValuePair("college",e));
                InputStream is = null;
                String result =null;
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost("http://192.168.43.65/bustracking/studentreg.php");
                try {
                    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = client.execute(post);
                    HttpEntity entity =response.getEntity();
                    is= entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
                    StringBuilder  builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine())!=null){
                        builder.append(line);
                    }
                    result =builder.toString();

                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (ClientProtocolException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                dialog.dismiss();
                Toast.makeText(RegisterStudentActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        }
        Insert insert = new Insert();
        insert.execute(names,unames,passs,emails,colleges);
    }
}
