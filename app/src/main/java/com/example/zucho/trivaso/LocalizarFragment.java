package com.example.zucho.trivaso;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
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

import java.util.ArrayList;

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


    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);

            Toast.makeText(getActivity(), "Provider: " + provider, Toast.LENGTH_LONG);

            mMap = googleMap;

            mMap.setOnMapClickListener(this);

            //mMap.getUiSettings().setZoomControlsEnabled(true);

            mMap.getUiSettings().setMyLocationButtonEnabled(true);

            //mMap.getUiSettings().isMapToolbarEnabled();

            //if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                //return;
            //}
            //mMap.setMyLocationEnabled(true);

        } catch (SecurityException ex) {
            Log.e(TAG, "Error", ex);
        }

        Location myLocation = new Location(TAG);



        // Add a marker and move the camera
        LatLng mLocation = new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
        MarkerOptions marker = new MarkerOptions();
        marker.position(mLocation);
        marker.title("Banheiro MyLocation");


        mMap.addMarker(marker);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mLocation));

        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLocation, 16.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLocation, 16));
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

    public void inserirBanheiros(ArrayList<Banheiro> banheiros){
        for (Banheiro i:banheiros){

            Banheiro b = (Banheiro) banheiros;

            LatLng mLocation = new LatLng(b.getLat(),b.getLon());
            MarkerOptions marker = new MarkerOptions();
            marker.position(mLocation);
            marker.title(b.getNome());

            mMap.addMarker(marker);

        }
    }
}
