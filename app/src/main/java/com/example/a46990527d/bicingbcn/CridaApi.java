package com.example.a46990527d.bicingbcn;
import android.net.Uri;
import android.support.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by aacerete on 10/02/17.
 */

public class CridaApi {

    private final String URL = "http://wservice.viabicing.cat/v2/stations";

    ArrayList<Station> getBicing(){

        Uri builtUri = Uri.parse(URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return cridaApi(url);
    }

    @Nullable
    private ArrayList<Station> cridaApi(String url){

        try {
            String JsonResponse = HttpUtils.get(url);
            return procesarJson(JsonResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<Station> procesarJson(String jsonResponse){

        ArrayList<Station> stations = new ArrayList<>();

        try {

            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonStations = data.getJSONArray("stations");


            for (int i = 0; i < jsonStations.length(); i++) {

                JSONObject jsonStation = jsonStations.getJSONObject(i);
                Station station = new Station();

                station.setId(Integer.parseInt(jsonStation.getString("id")));

                if (jsonStation.getString("type").equalsIgnoreCase("bike")){
                    station.setElectric(false);
                }else {
                    station.setElectric(true);
                }

                station.setLatitude( Double.parseDouble(jsonStation.getString("latitude")));
                station.setLongitude( Double.parseDouble(jsonStation.getString("longitude")));
                station.setStreetName(jsonStation.getString("streetName"));
                station.setStreetNumber(jsonStation.getString("streetNumber"));
                station.setAltitude( Double.parseDouble(jsonStation.getString("altitude")));
                station.setSlots(Integer.parseInt(jsonStation.getString("slots")));
                station.setBikes(Integer.parseInt(jsonStation.getString("bikes")));

                stations.add(station);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stations;
    }
}