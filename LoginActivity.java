package com.example.sri.bustracking;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Button loginb;
    TextView unamet,passt;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unamet = (TextView)findViewById(R.id.unamel);
        passt = (TextView)findViewById(R.id.passl);
        loginb = (Button)findViewById(R.id.login);

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unames = unamet.getText().toString();
                String passs = passt.getText().toString();

                StudentLogin(unames,passs);

            }

        });

    }

    private void StudentLogin(String unames, String passs) {
        class Insert extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(LoginActivity.this, "Loading", "Please Wait");
                super.onPreExecute();

            }


            @Override
            protected String doInBackground(String... strings) {

                String a = strings[0];
                String b = strings[1];

                List<NameValuePair> nameValuePairs = new ArrayList<>();
                nameValuePairs.add(new BasicNameValuePair("username", a));
                nameValuePairs.add(new BasicNameValuePair("password", b));
                InputStream is = null;
                String result = null;
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost("http://192.168.43.65/bustracking/studloginform.php");
                try {
                    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = client.execute(post);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    result = builder.toString();

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
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        }
        Insert insert = new Insert();
        insert.execute(unames, passs);
    }

}
