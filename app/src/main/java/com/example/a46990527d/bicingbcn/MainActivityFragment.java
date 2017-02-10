package com.example.a46990527d.bicingbcn;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private org.osmdroid.views.MapView mvMap;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);
        mvMap = (org.osmdroid.views.MapView) view.findViewById(R.id.mvMap);

        initializeMap();

        return view;

    }

    private void initializeMap() {

        mvMap.setTileSource(TileSourceFactory.MAPNIK);
        mvMap.setTilesScaledToDpi(true);
        mvMap.setBuiltInZoomControls(true);
        mvMap.setMultiTouchControls(true);

    }

}
