package sematech.training.WorkoutTwo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import io.nlopez.smartlocation.SmartLocation;
import sematech.training.R;
import sematech.training.utils.BaseApplication;
import sematech.training.utils.Publics;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageView mainMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        bind();
        mapFragment.getMapAsync(this);
    }

    private void bind() {
        mainMarker = findViewById(R.id.marker);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        getPermission();

        mainMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geocoder geocoder;
                List<Address> addresses = null;
                geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
                Double latitude ;
                Double longitude ;
                latitude = getMarkerLocation().latitude;
                longitude = getMarkerLocation().longitude;
                try {
                    addresses = geocoder.getFromLocation(latitude,longitude,2); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                    String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    String city = addresses.get(0).getLocality();
                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
                    Toast.makeText(MapsActivity.this,address , Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(getMarkerLocation(), 12.0f));
        try {

            if (isBetween()) {
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.dark));
            }
        } catch (Exception e) {

        }
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return true;
            }
        });
        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {

                mMap.clear();
                LatLng markerLoc = getMarkerLocation();
                setRandomlocation(markerLoc);
            }
        });

    }

    private void setDefaultLocation() {

    }

    private boolean isBetween() {
        int from = 2300;
        int to = 800;
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int t = c.get(Calendar.HOUR_OF_DAY) * 100 + c.get(Calendar.MINUTE);
        boolean isBetween = to > from && t >= from && t <= to || to < from && (t >= from || t <= to);
        return isBetween;
    }

    public void setRandomlocation(LatLng loc) {
        int radius = 0;
        for (int i = 1; i < 10; i++) {
            setMarker(loc, radius, i);
            radius += 45;
        }


//        LatLng targetNorthEast1 = SphericalUtil.computeOffset(loc, radius * Math.sqrt(2), 45);
//        LatLng targetNorthEast2 = SphericalUtil.computeOffset(loc, 40 * Math.sqrt(2), 80);
//        LatLng targetNorthEast3 = SphericalUtil.computeOffset(loc, 20 * Math.sqrt(2), 90);
//        LatLng targetNorthEast4 = SphericalUtil.computeOffset(loc, 30 * Math.sqrt(2), 100);
//        LatLng targetNorthEast5 = SphericalUtil.computeOffset(loc, radius * Math.sqrt(2), 150);
//        LatLng targetNorthEast6= SphericalUtil.computeOffset(loc, radius * Math.sqrt(2), 1);
//        LatLng targetNorthEast7 = SphericalUtil.computeOffset(loc, radius * Math.sqrt(2), 5);
//
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast1).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast2).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast3).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast4).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast5).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast6).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
//        mMap.addMarker(new MarkerOptions().position(targetNorthEast7).title("Marker ").icon(BitmapDescriptorFactory.fromBitmap(getMarker())));
    }

    public Bitmap getMarker() {
        BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.car);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 84, 84, false);
        return smallMarker;
    }

    private Double getRandomCounterDouble() {
        double start = 10;
        double end = 50;
        Random random = new Random();
        return (start + (random.nextDouble() * (end - start)));
    }

    public LatLng getMarkerLocation() {
        Double lat = mMap.getCameraPosition().target.latitude;
        Double lon = mMap.getCameraPosition().target.longitude;
        LatLng loc = new LatLng(lat, lon);
        return loc;
    }

    public Marker setMarker(LatLng loc, int r, int i) {
        Marker mMarker = mMap.addMarker(new MarkerOptions()
                .position(SphericalUtil.computeOffset(loc, getRandomCounterDouble() * Math.sqrt(2), r))
                .title("Marker " + i)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));
        return mMarker;
    }
    void getMyLocation() {
        SmartLocation.with(this).location()
                .oneFix()
                .start(L -> {
                    Double latitude = L.getLatitude();
                    Double longitude = L.getLongitude();
                    LatLng currentLoc = new LatLng(latitude, longitude);
                    mMap.addMarker(new MarkerOptions().position(currentLoc).title("You're Here"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLoc));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 12.0f));

                });
    }
    void getPermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                getMyLocation();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();

    }
}
