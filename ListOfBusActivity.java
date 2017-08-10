package com.example.sri.bustracking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
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

public class ListOfBusActivity extends AppCompatActivity {
    ListView lv;
ArrayList<HashMap<String,String>> contact;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_bus);
        lv = (ListView)findViewById(R.id.listbus);
        contact =  new ArrayList<HashMap<String, String>>();
        String str = getIntent().getStringExtra("bvalue");
        if(str.equals("list2"))
        {
            new GetAvailableBus().execute();

        }

        if(str.equals("list1"))
        {
            new GetListBus().execute();
        }


    }

    private class GetAvailableBus  extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(ListOfBusActivity.this,"Loading","Fetching...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            InputStream is = null;
            String result = null;
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.43.65/bustracking/fetchactive.php");
            try {

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
                JSONObject object  =  new JSONObject(result);
                JSONArray array = object.getJSONArray("results");
                for(int i = 0;i<array.length();i++){
                    JSONObject c =  array.getJSONObject(i);
                    String busno = c.getString("BusNo");
                    String drivername = c.getString("Name");
                    HashMap<String,String> map =  new HashMap<String,String>();
                    map.put("GETBUS",busno);
                    map.put("GETDRIVER",drivername);
                    contact.add(map);
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
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            ListAdapter adapter = new SimpleAdapter(ListOfBusActivity.this,contact,R.layout.layout,new String[]{"GETBUS","GETDRIVER"},new int[]{R.id.textView3,R.id.textView5});
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView  as = (TextView)view.findViewById(R.id.textView3);
                    String bus =  as.getText().toString();
                    Intent in1 = new Intent(ListOfBusActivity.this,DisplayDetailsActivity.class);
                    in1.putExtra("valueselected","selectop");
                    in1.putExtra("busno",bus);
                    startActivity(in1);
                    Toast.makeText(ListOfBusActivity.this,"busno"+bus,Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private class GetListBus extends AsyncTask<Void,Void,Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(ListOfBusActivity.this,"Loading","Fetching...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            InputStream is = null;
            String result = null;
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.43.65/bustracking/fetch.php");
            try {

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
                JSONObject object  =  new JSONObject(result);
                JSONArray array = object.getJSONArray("results");
                for(int i = 0;i<array.length();i++){
                    JSONObject c =  array.getJSONObject(i);
                    String busno = c.getString("BusNo");
                    String drivername = c.getString("Name");
                    HashMap<String,String> map =  new HashMap<String,String>();
                    map.put("GETBUS",busno);
                    map.put("GETDRIVER",drivername);
                    contact.add(map);
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
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            ListAdapter adapter = new SimpleAdapter(ListOfBusActivity.this,contact,R.layout.layout,new String[]{"GETBUS","GETDRIVER"},new int[]{R.id.textView3,R.id.textView5});
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView sa = (TextView)view.findViewById(R.id.textView3);
                    String bus = sa.getText().toString();
                    Intent in2 = new Intent(ListOfBusActivity.this,DisplayDetailsActivity.class);
                    in2.putExtra("valueselected","availableop");
                    in2.putExtra("busno",bus);
                    startActivity(in2);
                    Toast.makeText(ListOfBusActivity.this,"busno"+bus,Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
