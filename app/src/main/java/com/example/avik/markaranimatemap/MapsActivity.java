package com.example.avik.markaranimatemap;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker myMarker , mCarMarker, myRedCarMarkar;

    Bitmap mMarkerIcon,mRedCarMarkerIcon;
    private List<LatLng> mPathPolygonPoints = new ArrayList<>();
    private List<LatLng> mRedCarlatlongPoints = new ArrayList<>();
    float MOVE_ANIMATION_DURATION = 5000;
    float TURN_ANIMATION_DURATION = 3000;
    private int mIndexCurrentPoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        addLatLong();
        addRedCarLatLong();
    }

    private void addRedCarLatLong() {
        mRedCarlatlongPoints.add(new LatLng(22.5811275,88.4301834));
        mRedCarlatlongPoints.add(new LatLng(22.5808328,88.430403));
        mRedCarlatlongPoints.add(new LatLng(22.5804489,88.4307555));
        mRedCarlatlongPoints.add(new LatLng(22.5802019,88.4311123));
        mRedCarlatlongPoints.add(new LatLng(22.5799715,88.4315388));
        mRedCarlatlongPoints.add(new LatLng(22.579711, 88.432169));
        mRedCarlatlongPoints.add(new LatLng(22.579519, 88.432599));
        mRedCarlatlongPoints.add(new LatLng(22.579365, 88.432923));
        mRedCarlatlongPoints.add(new LatLng(22.579196, 88.433292));
        mRedCarlatlongPoints.add(new LatLng(22.578953,88.4335953));
        mRedCarlatlongPoints.add(new LatLng(22.578797,88.4341633));
        mRedCarlatlongPoints.add(new LatLng(22.578563,88.4347453));
        mRedCarlatlongPoints.add(new LatLng(22.578285,88.4351966));

    }

    private void addLatLong() {

        mPathPolygonPoints.add(new LatLng(22.5792377,88.426688));
        mPathPolygonPoints.add(new LatLng(22.5789857,88.4268275));
        mPathPolygonPoints.add(new LatLng(22.5786978,88.4269683));
        mPathPolygonPoints.add(new LatLng(22.5784445,88.4271058));
        mPathPolygonPoints.add(new LatLng(22.5783312,88.4271755));
        mPathPolygonPoints.add(new LatLng(22.5781715,88.4272647));
        mPathPolygonPoints.add(new LatLng(22.5780811,88.4273465));
        mPathPolygonPoints.add(new LatLng(22.5778099,88.4275222));
        mPathPolygonPoints.add(new LatLng(22.577717,88.4276452));
        mPathPolygonPoints.add(new LatLng(22.5774817,88.4279027));
        mPathPolygonPoints.add(new LatLng(22.577309,88.4282025));
        mPathPolygonPoints.add(new LatLng(22.5772706,88.4284338));
        mPathPolygonPoints.add(new LatLng(22.5770508,88.4288643));
        mPathPolygonPoints.add(new LatLng(22.5769233,88.4291131));
        mPathPolygonPoints.add(new LatLng(22.5767703,88.4294665));
        mPathPolygonPoints.add(new LatLng(22.5765648,88.4298755));
        mPathPolygonPoints.add(new LatLng(22.5763109,88.4303429));
        mPathPolygonPoints.add(new LatLng(22.5761382,88.4308196));
        mPathPolygonPoints.add(new LatLng(22.5759636,88.4312361));
        mPathPolygonPoints.add(new LatLng(22.5757462,88.4317088));
        mPathPolygonPoints.add(new LatLng(22.5755914,88.4319609));
        mPathPolygonPoints.add(new LatLng(22.5755239,88.4321581));
        mPathPolygonPoints.add(new LatLng(22.5750334,88.4331116));
        mPathPolygonPoints.add(new LatLng(22.574896,88.4334924));
        mPathPolygonPoints.add(new LatLng(22.5748657,88.4336071));
        mPathPolygonPoints.add(new LatLng(22.5750223,88.4337043));
        mPathPolygonPoints.add(new LatLng(22.5750712,88.4337365));
        mPathPolygonPoints.add(new LatLng(22.5754576,88.4339397));
        mPathPolygonPoints.add(new LatLng(22.5759399,88.4341724));
        mPathPolygonPoints.add(new LatLng(22.5761337,88.4342783));
        mPathPolygonPoints.add(new LatLng(22.5765999,88.4345613));
        mPathPolygonPoints.add(new LatLng(22.5765999,88.4345613));
        mPathPolygonPoints.add(new LatLng(22.5767318,88.4343903));
        mPathPolygonPoints.add(new LatLng(22.5767609,88.4343916));
        mPathPolygonPoints.add(new LatLng(22.5770346,88.4340631));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        final LatLng myPosition = new LatLng(22.5790446,88.4267295);
        final LatLng redCarPosition = new LatLng(22.5811275,88.4301834);

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);
        googleMap.setTrafficEnabled(false);
        googleMap.setIndoorEnabled(false);
        googleMap.setBuildingsEnabled(false);
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        /////////////// setup Map Style ///////////////
        MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this,R.raw.google_mapstyle);
        mMap.setMapStyle(mapStyleOptions);


        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                .target(googleMap.getCameraPosition().target)
                .zoom(18)
                .bearing(0)
                .tilt(0)
                .build()));

//        myMarker = googleMap.addMarker(new MarkerOptions()
//                .position(myPosition)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car_markar))
//                .title("I'm Here"));

        mMarkerIcon = BitmapFactory.decodeResource(getResources(), R.drawable.carmarkaryellow);
        mRedCarMarkerIcon = BitmapFactory.decodeResource(getResources(), R.drawable.carmarkarred);

        mCarMarker = googleMap.addMarker(new MarkerOptions()
                .position(myPosition)
                .icon(BitmapDescriptorFactory.fromBitmap(mMarkerIcon))
                .title("I'm Here"));

        myRedCarMarkar = googleMap.addMarker(new MarkerOptions()
                .position(redCarPosition)
                .icon(BitmapDescriptorFactory.fromBitmap(mRedCarMarkerIcon))
                .title("I'm Here"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLng(mCarMarker.getPosition()));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        googleMap.setMyLocationEnabled(true);

        Timer delay = new Timer();
        delay.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        animateCarMove(mCarMarker, mPathPolygonPoints.get(0), mPathPolygonPoints.get(1), MOVE_ANIMATION_DURATION);
                        //animateCarMove(myRedCarMarkar, mRedCarlatlongPoints.get(0), mRedCarlatlongPoints.get(1), MOVE_ANIMATION_DURATION);
                    }
                });
            }
        }, 5000);




//        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                final LatLng startPosition = myMarker.getPosition();
//                final LatLng finalPosition = new LatLng(22.575234,88.4329412);
//                final Handler handler = new Handler();
//                final long start = SystemClock.uptimeMillis();
//                final Interpolator interpolator = new AccelerateDecelerateInterpolator();
//                final float durationInMs = 3000;
//                final boolean hideMarker = false;
//
//                handler.post(new Runnable() {
//                    long elapsed;
//                    float t;
//                    float v;
//
//                    @Override
//                    public void run() {
//                        // Calculate progress using interpolator
//                        elapsed = SystemClock.uptimeMillis() - start;
//                        t = elapsed / durationInMs;
//
//                        LatLng currentPosition = new LatLng(
//                                startPosition.latitude * (1 - t) + finalPosition.latitude * t,
//                                startPosition.longitude * (1 - t) + finalPosition.longitude * t);
//
//                        myMarker.setPosition(currentPosition);
//
//                        // Repeat till progress is complete.
//                        if (t < 1) {
//                            // Post again 16ms later.
//                            handler.postDelayed(this, 16);
//                        } else {
//                            if (hideMarker) {
//                                myMarker.setVisible(false);
//                            } else {
//                                myMarker.setVisible(true);
//                            }
//                        }
//                    }
//                });
//
//                return true;
//
//            }
//        });


        //////////////////////////////////////////////////////////////////


    }

    private void animateCarMove(final Marker marker, final LatLng beginLatLng, final LatLng endLatLng, final float duration) {
        final Handler handler = new Handler();
        final long startTime = SystemClock.uptimeMillis();

        final Interpolator interpolator = new LinearInterpolator();

        // set car bearing for current part of path
        float angleDeg = (float)(180 * getAngle(beginLatLng, endLatLng) / Math.PI);
        Matrix matrix = new Matrix();
        matrix.postRotate(angleDeg);
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(mMarkerIcon, 0, 0, mMarkerIcon.getWidth(), mMarkerIcon.getHeight(), matrix, true)));

        handler.post(new Runnable() {
            @Override
            public void run() {
                // calculate phase of animation
                long elapsed = SystemClock.uptimeMillis() - startTime;
                float t = interpolator.getInterpolation((float) elapsed / duration);
                // calculate new position for marker
                double lat = (endLatLng.latitude - beginLatLng.latitude) * t + beginLatLng.latitude;
                double lngDelta = endLatLng.longitude - beginLatLng.longitude;

                if (Math.abs(lngDelta) > 180) {
                    lngDelta -= Math.signum(lngDelta) * 360;
                }
                double lng = lngDelta * t + beginLatLng.longitude;

                marker.setPosition(new LatLng(lat, lng));    ////////

////////////////////////////////////// Camera Move With markar ////////////////////////////////////////////////////////
//                CameraPosition cameraPosition =
//                        new CameraPosition.Builder()
//                                .target(new LatLng(lat,lng))
//                                .bearing(0)
//                                .tilt(0)
//                                .zoom(18)
//                                .build();
//
//                marker.setPosition(new LatLng(lat, lng));
//
//                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition ),
//                        1000, null);
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
                // if not end of line segment of path
                if (t < 1.0) {
                    // call next marker position
                    handler.postDelayed(this, 13);
                } else {
                    // call turn animation
                    nextTurnAnimation();
                }
            }
        });
    }

    private void nextTurnAnimation() {

        mIndexCurrentPoint++;

        if (mIndexCurrentPoint < mPathPolygonPoints.size() - 1) {
            LatLng prevLatLng = mPathPolygonPoints.get(mIndexCurrentPoint - 1);
            LatLng currLatLng = mPathPolygonPoints.get(mIndexCurrentPoint);
            LatLng nextLatLng = mPathPolygonPoints.get(mIndexCurrentPoint + 1);

            float beginAngle = (float)(180 * getAngle(prevLatLng, currLatLng) / Math.PI);
            float endAngle = (float)(180 * getAngle(currLatLng, nextLatLng) / Math.PI);

            animateCarTurn(mCarMarker, beginAngle, endAngle, TURN_ANIMATION_DURATION);
        }
    }

    private void animateCarTurn(final Marker marker, final float startAngle, float endAngle, final float duration) {

        final Handler handler = new Handler();
        final long startTime = SystemClock.uptimeMillis();
        final Interpolator interpolator = new LinearInterpolator();

        final float dAndgle = endAngle - startAngle;

        Matrix matrix = new Matrix();
        matrix.postRotate(startAngle);
        Bitmap rotatedBitmap = Bitmap.createBitmap(mMarkerIcon, 0, 0, mMarkerIcon.getWidth(), mMarkerIcon.getHeight(), matrix, true);
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(rotatedBitmap));

        handler.post(new Runnable() {
            @Override
            public void run() {

                long elapsed = SystemClock.uptimeMillis() - startTime;
                float t = interpolator.getInterpolation((float) elapsed / duration);

                Matrix m = new Matrix();
                m.postRotate(startAngle + dAndgle * t);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(mMarkerIcon, 0, 0, mMarkerIcon.getWidth(), mMarkerIcon.getHeight(), m, true)));

                if (t < 1.0) {
                    handler.postDelayed(this, 16);
                } else {
                    nextMoveAnimation();
                }
            }
        });
    }


    private void nextMoveAnimation() {
        if (mIndexCurrentPoint <  mPathPolygonPoints.size() - 1) {
            animateCarMove(mCarMarker, mPathPolygonPoints.get(mIndexCurrentPoint), mPathPolygonPoints.get(mIndexCurrentPoint+1), MOVE_ANIMATION_DURATION);
        }
    }

    private double getAngle(LatLng beginLatLng, LatLng endLatLng) {
        double f1 = Math.PI * beginLatLng.latitude / 180;
        double f2 = Math.PI * endLatLng.latitude / 180;
        double dl = Math.PI * (endLatLng.longitude - beginLatLng.longitude) / 180;
        return Math.atan2(Math.sin(dl) * Math.cos(f2) , Math.cos(f1) * Math.sin(f2) - Math.sin(f1) * Math.cos(f2) * Math.cos(dl));
    }
}
