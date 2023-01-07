package com.example.projetsem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.IntentSender;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Granularity;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.Priority;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import io.github.sceneview.ar.ArSceneView;

public class Compass extends AppCompatActivity {

    private ImageView compass;
    private TextView textView;
    private Button button;

    private double mLat;
    private double mLong;
    private double dlat;
    private double dlong;
    private double latitudeNorthPole = 90.0f;
    private double longitudeNorthPole = 0.0f;

    //Sensor Variables
    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;
    private Sensor sensorMagneticField;

    //Compass Variables
    private float[] floatGravity = new float[3];
    private float[] floatGeoMagnetic = new float[3];
    private float[] floatOrientation = new float[3];
    private float[] rotationMatrix = new float[9];

    //Location Variables
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult locationResult) {
            super.onLocationResult(locationResult);
            mLat = locationResult.getLastLocation().getLatitude();
            mLong = locationResult.getLastLocation().getLongitude();
            getNorth();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        compass = findViewById(R.id.compass);
        button = findViewById(R.id.button);
        button.setBackgroundColor(Color.TRANSPARENT);
        textView = findViewById(R.id.textView);
        textView.setTextColor(Color.BLACK);


        //User location Initialization
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        //Phone sensors initialization
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorMagneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        Coordinats destinatin;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dlat = extras.getFloat("key1");
            dlong = extras.getFloat("key2");
            //textView.setText("Latitude: " + dlat + " Longitude: " + dlong);
        }

        button.setOnClickListener(v -> {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            getLocationUpdate();
            Toast.makeText(this, "Navigation starting", Toast.LENGTH_SHORT).show();
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    protected void getLocationUpdate(){

        LocationRequest locationRequest = new LocationRequest.Builder(500)
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                .setGranularity(Granularity.GRANULARITY_FINE)
                .setMinUpdateDistanceMeters(0.1f)
                .build();

        LocationSettingsRequest locationSettingsRequest = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)
                .build();

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest).addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @SuppressLint("MissingPermission")
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                if(task.isSuccessful()){

                    fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
                }else{
                    if(task.getException() instanceof ResolvableApiException){
                        try {
                            ResolvableApiException resolvableApiException = (ResolvableApiException) task.getException();
                            resolvableApiException.startResolutionForResult(Compass.this, 100);
                        } catch (IntentSender.SendIntentException e) {
                            Log.d("error debug", e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    protected void getNorth(){
        SensorEventListener sensorEventListenerAcc = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                floatGravity = event.values;
                SensorManager.getRotationMatrix(rotationMatrix, null, floatGravity, floatGeoMagnetic);
                SensorManager.getOrientation(rotationMatrix, floatOrientation);
                SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, rotationMatrix);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        SensorEventListener sensorEventListenerMag = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                floatGeoMagnetic = event.values;
                SensorManager.getRotationMatrix(rotationMatrix, null, floatGravity, floatGeoMagnetic);
                SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, rotationMatrix);
                SensorManager.getOrientation(rotationMatrix, floatOrientation);
                Location currentLocation = new Location(LocationManager.FUSED_PROVIDER);
                Location destination = new Location(LocationManager.FUSED_PROVIDER);
                currentLocation.setLatitude(mLat);
                currentLocation.setLongitude(mLong);
                destination.setLatitude(dlat);
                destination.setLongitude(dlong);
                float bearing = currentLocation.bearingTo(destination);
                float distence = currentLocation.distanceTo(destination);
                compass.setRotation((float) (bearing - (floatOrientation[0]) * 180 / Math.PI));
                if(distence < 1100){
                    textView.setText(distence + " m");
                }else {
                    textView.setText(distence/1000 + " km");
                }
                //textView.setText("mLat " + mLat + " mLong " + mLong+ "\n heading"+ (float) (bearing - (floatOrientation[0]) * 180 / Math.PI ));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListenerAcc, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerMag, sensorMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
    }


}