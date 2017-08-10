package com.example.sri.bustracking;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayDetailsActivity extends AppCompatActivity {

    Button trackb;
    Dialog dialog;
    TextView dname,bno,bfrom,bto,b1,b2,b3,b4,b5,b6;
    String strName,strBusNo,strFrom,strTo,strb1,strb2,strb3,strb4,strb5,strb6;
    String aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        trackb=(Button)findViewById(R.id.track);
        dname=(TextView)findViewById(R.id.dispname);
        bno=(TextView)findViewById(R.id.dispbusno);
        bfrom=(TextView)findViewById(R.id.dispfrom);
        bto=(TextView)findViewById(R.id.dispto);
        b1=(TextView)findViewById(R.id.dispbno1);
        b2=(TextView)findViewById(R.id.dispbno2);
        b3=(TextView)findViewById(R.id.dispbno3);
        b4=(TextView)findViewById(R.id.dispbno4);
        b5=(TextView)findViewById(R.id.dispbno5);
        b6=(TextView)findViewById(R.id.dispbno6);


        String str = getIntent().getStringExtra("valueselected");
        if(str.equals("availableop"))
        {
            trackb.setVisibility(View.GONE);

        }


        final String strb = getIntent().getStringExtra("busno");
        Toast.makeText(DisplayDetailsActivity.this,"the bus no selected is "+strb,Toast.LENGTH_SHORT).show();

        trackb = (Button)findViewById(R.id.track);
        trackb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayDetailsActivity.this,MapsingleActivity.class);
                i.putExtra("trackbus",strb);
                startActivity(i);

            }
        });


        new Displayall().execute(strb);


    }

    private class Displayall extends AsyncTask<String,Void,String>{
        ProgressDialog dialog;

        @Override
        protected String doInBackground(String... params) {
            String a = params[0];
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("busno", a));
            InputStream is = null;
            String result = null;
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.43.65/bustracking/singlebusview.php");
            try
            {
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = client.execute(post);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                {
                    builder.append(line);
                }
                result = builder.toString();
                JSONObject object = new JSONObject(result);
                JSONArray array = object.getJSONArray("results");
                for(int i = 0;i<array.length();i++){
                    JSONObject c = array.getJSONObject(i);
                    strName = c.getString("Name");
                    strBusNo = c.getString("BusNo");
                    strFrom = c.getString("From");
                    strTo = c.getString("To");
                    strb1 = c.getString("BusStop1");
                    strb2 = c.getString("BusStop2");
                    strb3 = c.getString("BusStop3");
                    strb4 = c.getString("BusStop4");
                    strb5 = c.getString("BusStop5");
                    strb6 = c.getString("BusStop6");
                }


            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (ClientProtocolException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(DisplayDetailsActivity.this,"","loading....");
        }



        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dialog.dismiss();
            Toast.makeText(DisplayDetailsActivity.this,result,Toast.LENGTH_SHORT).show();
            dname.setText(strName);
            bno.setText(strBusNo);
            bfrom.setText(strFrom);
            bto.setText(strTo);
            b1.setText(strb1);
            b2.setText(strb2);
            b3.setText(strb3);
            b4.setText(strb4);
            b5.setText(strb5);
            b6.setText(strb6);
        }
    }
}
