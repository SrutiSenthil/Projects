package com.example.sri.bustracking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class RegisterBusDriverActivity extends AppCompatActivity {
    Button registerbus , cancelbus;
    EditText name,uname,pass,from,to,busno;
    Spinner sp1,sp2,sp3,sp4,sp5,sp6;
    String item1,item2,item3,item4,item5,item6;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_bus_driver);

        name = (EditText)findViewById(R.id.nameed);
        busno = (EditText)findViewById(R.id.bnoed);
        uname = (EditText)findViewById(R.id.unameed);
        pass = (EditText)findViewById(R.id.passed);
        from = (EditText)findViewById(R.id.fromed);
        to = (EditText)findViewById(R.id.toed);
        sp1 = (Spinner)findViewById(R.id.spinner1);
        sp2 = (Spinner)findViewById(R.id.spinner2);
        sp3 = (Spinner)findViewById(R.id.spinner3);
        sp4 = (Spinner)findViewById(R.id.spinner4);
        sp5 = (Spinner)findViewById(R.id.spinner5);
        sp6 = (Spinner)findViewById(R.id.spinner6);


        String[] spinnerarray = {"icf","Maharani","Avadi","thiruvanmiyur","villivalkam","Brindhavan","rakki theatre","rto office","noor hotel","Aminjikarai","ambattur telephone exchange","srp tools","`sanyani","taylors road","Canara bank","adayar depo","joint office","sterling road","golden flats","gandhinagar","naathamuni","gemini","vavin","ramanujam it park"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,spinnerarray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        sp1.setAdapter(arrayAdapter);
        sp2.setAdapter(arrayAdapter);
        sp3.setAdapter(arrayAdapter);
        sp4.setAdapter(arrayAdapter);
        sp5.setAdapter(arrayAdapter);
        sp6.setAdapter(arrayAdapter);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item1 = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item2 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item3 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item4 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item5 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item6 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    registerbus= (Button)findViewById(R.id.registerb);
        registerbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameb = name.getText().toString();
                String busnob = busno.getText().toString();
                String unameb = uname.getText().toString();
                String passb = pass.getText().toString();
                String fromb = from.getText().toString();
                String tob = to.getText().toString();

               BusDriverReg(nameb,busnob,unameb,passb,fromb,tob,item1,item2,item3,item4,item5,item6);
Toast.makeText(RegisterBusDriverActivity.this,nameb+busnob+unameb+passb+fromb+tob+item1+item2+item3+item4+item5+item6,Toast.LENGTH_SHORT).show();
            }

            private void BusDriverReg(String nameb, String busnob, String unameb, String passb, String fromb, String tob, String item1, String item2, String item3, String item4, String item5, String item6) {

                class Insert extends AsyncTask<String,Void,String>{


                    @Override
                    protected void onPreExecute() {
                        dialog = ProgressDialog.show(RegisterBusDriverActivity.this,"Loading","Please Wait");
                        super.onPreExecute();

                    }

                    @Override
                    protected String doInBackground(String... strings) {

                        String a = strings[0];
                        String b = strings[1];
                        String c = strings[2];
                        String d = strings[3];
                        String e = strings[4];
                        String f = strings[5];
                        String g = strings[6];
                        String h = strings[7];
                        String i = strings[8];
                        String j = strings[9];
                        String k = strings[10];
                        String l = strings[11];
                        List<NameValuePair> nameValuePairs = new ArrayList<>();
                        nameValuePairs.add(new BasicNameValuePair("name",a));
                        nameValuePairs.add(new BasicNameValuePair("username",b));
                        nameValuePairs.add(new BasicNameValuePair("password",c));
                        nameValuePairs.add(new BasicNameValuePair("from",d));
                        nameValuePairs.add(new BasicNameValuePair("to",e));
                        nameValuePairs.add(new BasicNameValuePair("busno",f));
                        nameValuePairs.add(new BasicNameValuePair("bs1",g));
                        nameValuePairs.add(new BasicNameValuePair("bs2",h));
                        nameValuePairs.add(new BasicNameValuePair("bs3",i));
                        nameValuePairs.add(new BasicNameValuePair("bs4",j));
                        nameValuePairs.add(new BasicNameValuePair("bs5",k));
                        nameValuePairs.add(new BasicNameValuePair("bs6",l));

                        InputStream is = null;
                        String result =null;
                        HttpClient client = new DefaultHttpClient();
                        HttpPost post = new HttpPost("http://192.168.43.65/bustracking/busdriverreg.php");
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
                        Toast.makeText(RegisterBusDriverActivity.this,s,Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegisterBusDriverActivity.this,BusLocationActivity.class);
                        startActivity(i);
                    }

                }
Insert is = new Insert();
                is.execute(nameb,busnob,unameb,passb,fromb,tob,item1,item2,item3,item4,item5,item6);
            }

        });

        cancelbus = (Button)findViewById(R.id.cancelb);
        cancelbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterBusDriverActivity.this,Option.class);
                startActivity(i);
            }
        });

    }
}
