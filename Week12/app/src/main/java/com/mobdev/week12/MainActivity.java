package com.mobdev.week12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager = null;
    private Sensor stepSensor;
    private int totalSteps = 0;
    private int previewTotalSteps = 0;
    private ProgressBar progressBar;
    private TextView steps;
    private Button button, button2;
    private static final int REQUEST_BLUETOOTH_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        steps = findViewById(R.id.steps);


        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{android.Manifest.permission.ACTIVITY_RECOGNITION}, 1);
        }

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        assert sensorManager != null;
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (stepSensor == null) {
            Toast.makeText(this, "This device has no sensor in onCreate", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Have sensor", Toast.LENGTH_SHORT).show();
        }

        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (connectivity != null) {
                    NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();

                    if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
                        Toast.makeText(getApplicationContext(), "Have a network", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Don't have a connection", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Camera camera = android.hardware.Camera.open();
                BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
                if (bluetooth == null) {
                    Toast.makeText(MainActivity.this, "Device does not support Bluetooth", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!bluetooth.isEnabled()) {
                    Toast.makeText(MainActivity.this, "Bluetooth is not enabled, you may want to prompt the user to enable it", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
                    // Request the permission
                    ActivityCompat.requestPermissions(getParent(), new String[]{android.Manifest.permission.BLUETOOTH_ADMIN}, REQUEST_BLUETOOTH_PERMISSION);
                } else {
                    Toast.makeText(MainActivity.this, "Permission already granted, start discovery", Toast.LENGTH_SHORT).show();
                    bluetooth.startDiscovery();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            totalSteps = (int) sensorEvent.values[0];
            int currentSteps = totalSteps - previewTotalSteps;
            steps.setText(String.valueOf(currentSteps));

            progressBar.setProgress(currentSteps);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}