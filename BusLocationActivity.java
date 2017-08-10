package com.example.sri.bustracking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
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
import java.util.List;

public class BusLocationActivity extends AppCompatActivity {

    Button startb, stopb;
    Double strlat, strlong;

    private LocationManager locationManager;
    private Location loc;
    String provider;

    GPSTracker gps = new GPSTracker(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_location);
        gps = new GPSTracker(BusLocationActivity.this);

// check if GPS enabled
        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                    + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
        startb = (Button) findViewById(R.id.startbus);
        stopb = (Button) findViewById(R.id.stopbus);

        //locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        startb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          /*     strlat= loc.getLatitude();
                strlong = loc.getLongitude();

                Toast.makeText(BusLocationActivity.this,""+strlat+":"+strlong,Toast.LENGTH_SHORT).show();*/

            }
        });

// Getting LocationManager object

    }

}

