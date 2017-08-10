package com.example.sri.bustracking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
import java.util.Timer;
import java.util.TimerTask;

public class MapsingleActivity extends FragmentActivity {

    String strlat, strlong;
    Timer timer = new Timer();
    TimerTask timerTask;
    ProgressDialog dialog;
    Double latl, longl;
    double ll, lo;
    private GoogleMap mMap;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsingle);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
/*        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            // ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        final String trackb = getIntent().getStringExtra("trackbus");
        Toast.makeText(MapsingleActivity.this, "the bus to be tracked is " + trackb, Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"lattii"+strlat,Toast.LENGTH_SHORT).show();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        new PlotBus().execute(trackb);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {

                            @Override
                            public void run() {

                            }
                        }, 1000);

                    }
                });
            }
        }, 0, 10000);
        // Add a marker in Sydney and move the camera
 /*      */
    }
    /*
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    class PlotBus extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(MapsingleActivity.this, "", "loading....");
        }

        @Override
        protected String doInBackground(String... params) {
            String a = params[0];
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("busno", a));
            InputStream is = null;
            String result = null;
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.43.65/bustracking/tracksinglebus.php");
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
                JSONObject object = new JSONObject(result);
                JSONArray array = object.getJSONArray("results");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject c = array.getJSONObject(i);
                    strlat = c.getString("latitude");
                    strlong = c.getString("longitude");
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
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dialog.dismiss();
            Toast.makeText(MapsingleActivity.this, result, Toast.LENGTH_SHORT).show();
            latl = Double.parseDouble(strlat);
            longl = Double.parseDouble(strlong);

             ll= Double.valueOf(strlat);
             lo = Double.valueOf(strlong);
            LatLng sydney = new LatLng(Double.parseDouble(strlat),Double.parseDouble(strlong));
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        }
/*
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

                //toast.cancel();

                return true;
            }

            return super.onKeyDown(keyCode, event);
        }
*/
    }
}


