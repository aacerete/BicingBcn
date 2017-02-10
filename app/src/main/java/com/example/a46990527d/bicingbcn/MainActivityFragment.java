package com.example.a46990527d.bicingbcn;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.*;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private CridaApi cridaApi = new CridaApi();
    private org.osmdroid.views.MapView mvMap;

    private IMapController mapController;
    private MyLocationNewOverlay myLocationOverlay;
    private MinimapOverlay mMinimapOverlay;
    private ScaleBarOverlay mScaleBarOverlay;
    private CompassOverlay mCompassOverlay;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);
        mvMap = (org.osmdroid.views.MapView) view.findViewById(R.id.mvMap);

        initializeMap();
        setZoom();
        setOverlays();
        //Reactualitza el mapa
        mvMap.invalidate();

        return view;

    }

    private void initializeMap() {

        mvMap.setTileSource(TileSourceFactory.MAPNIK);
        mvMap.setTilesScaledToDpi(true);
        mvMap.setBuiltInZoomControls(true);
        mvMap.setMultiTouchControls(true);


    }

    private void setZoom() {
        mapController = mvMap.getController();
       // mapController.setCenter(new GeoPoint(41.383333, 2.183333));
        mapController.setZoom(20);
    }

    private void setOverlays() {
        final DisplayMetrics dm = getResources().getDisplayMetrics();
        myLocationOverlay = new MyLocationNewOverlay(
                new GpsMyLocationProvider(getContext()),
                mvMap
        );

        myLocationOverlay.enableMyLocation();
        myLocationOverlay.runOnFirstFix(new Runnable() {
            @Override
            public void run() {
                mapController.animateTo(myLocationOverlay.getMyLocation());
            }
        });


        mvMap.getOverlays().add(myLocationOverlay);

    }


    private void refresh(){

        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Station>> {

        @Override
        protected ArrayList<Station> doInBackground(Void... voids) {

            ArrayList<Station> result;
            result = cridaApi.getBicing();

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Station> stations) {

            for (Station station : stations){

                Log.d("Carrer", station.getStreetName());
            }

        }
    }

}
