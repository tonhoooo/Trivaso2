package com.example.zucho.trivaso;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocalizarFragment extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener, LocationListener {

    private static final String TAG = "LocalizarFragment";

    private GoogleMap mMap;

    private LocationManager locationManager;

    Marker currLocationMarker;

    LatLng latLng;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);

            Toast.makeText(getActivity(), "Provider: "+ provider, Toast.LENGTH_LONG);

            mMap = googleMap;

            mMap.setOnMapClickListener(this);

            mMap.getUiSettings().setZoomControlsEnabled(true);

            mMap.getUiSettings().setMyLocationButtonEnabled(true);

            mMap.setMyLocationEnabled(true);

        }catch(SecurityException ex){
            Log.e(TAG, "Error", ex);
        }

        // Add a marker in Sydney and move the camera
        LatLng univates = new LatLng(-29.4451112, -51.9546);
        MarkerOptions marker = new MarkerOptions();
        marker.position(univates);
        marker.title("Banheiro da UNIVATES");


        mMap.addMarker(marker);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(univates));

        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(univates, 16.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(univates,16));

    }

    @Override
    public void onMapClick(LatLng latLng) {
        //Toast.makeText(getContext(), "Coordenadas: " + latLng.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {

            //place marker at current position
            //mGoogleMap.clear();
            if (currLocationMarker != null) {
                currLocationMarker.remove();
            }
            latLng = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Position");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            currLocationMarker = mMap.addMarker(markerOptions);

            //Toast.makeText(this,"Location Changed",Toast.LENGTH_SHORT).show();

            //zoom to current position:
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));

    }
}
