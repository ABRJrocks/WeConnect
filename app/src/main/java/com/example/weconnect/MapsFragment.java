package com.example.weconnect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        mapView = rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        // Initialize the TextViews
        TextView addressTextView = rootView.findViewById(R.id.addressTextView);
        TextView phoneTextView = rootView.findViewById(R.id.phoneTextView);
        TextView emailTextView = rootView.findViewById(R.id.emailTextView);

        // Set your contact information
        addressTextView.setText("Address: Riphah International University, Raiwind Rd.");
        phoneTextView.setText("Phone: 123-4567-891");
        emailTextView.setText("Email: developers@weconnect.com");

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        // Customize your map settings
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker to a location
        LatLng location = new LatLng(31.377283, 74.230757);
        googleMap.addMarker(new MarkerOptions().position(location).title("Riphah International University"));

        // Move the camera to the marker's location
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f));
    }
}
