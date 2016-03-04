package com.example.sonam.givelife;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.463703, 89.638824)).title("JDNR Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.427800, 89.405569)).title("Paro General Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(26.861515, 91.467093)).title("Deothang Military Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.584306, 89.858573)).title("Punakha Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.035658, 88.883858)).title("Sipsu Samtse"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.087386, 89.540033)).title("Tsimalakha"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(26.881808, 90.523739)).title("Chusang BHU"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.278562, 91.239030)).title("Mongar Referal Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.278562, 91.239030)).title("Tashigang General Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(26.805605, 91.504000)).title("Sam/Jon General Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.556275, 90.746207)).title("Jakar Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.143992, 90.699515)).title("Yabilapcha Hospital"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.506135, 90.503305)).title("Trongsa General Hospital"));

        mMap.setMyLocationEnabled(true);
    }
}
