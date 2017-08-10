package com.example.sri.bustracking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by EOTrainee on 4/6/2017.
 */

public class MarkerJSONParser {

    /** Receives a JSONObject and returns a list */
    public List<HashMap<String,String>> parse(JSONObject jObject){

        JSONArray jMarkers = null;
        try {
            /** Retrieves all the elements in the 'markers' array */
            jMarkers = jObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /** Invoking getMarkers with the array of json object
         * where each json object represent a marker
         */
        return getMarkers(jMarkers);
    }

    private List<HashMap<String, String>> getMarkers(JSONArray jMarkers){
        int markersCount = jMarkers.length();
        List<HashMap<String, String>> markersList = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> marker = null;

        /** Taking each marker, parses and adds to list object */
        for(int i=0; i<markersCount;i++){
            try {
                /** Call getMarker with marker JSON object to parse the marker */
                marker = getMarker((JSONObject)jMarkers.get(i));
                markersList.add(marker);
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return markersList;
    }

    /** Parsing the Marker JSON object */
    private HashMap<String, String> getMarker(JSONObject jMarker){

        HashMap<String, String> marker = new HashMap<String, String>();
        String lat = "-NA-";
        String lng ="-NA-";

        try {
            // Extracting latitude, if available
            if(!jMarker.isNull("latitude")){
                lat = jMarker.getString("latitude");
            }

            // Extracting longitude, if available
            if(!jMarker.isNull("longitude")){
                lng = jMarker.getString("longitude");
            }

            marker.put("latitude", lat);
            marker.put("longitude", lng);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return marker;
    }
}