package com.mobdev.week11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent serviceIntent = new Intent(getApplicationContext(), CustomService.class);
                startService(serviceIntent);
                Toast.makeText(MainActivity.this, "start service", Toast.LENGTH_SHORT).show();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(getApplicationContext(), CustomService.class);
                stopService(serviceIntent);
                Toast.makeText(MainActivity.this, "stop service", Toast.LENGTH_SHORT).show();
            }
        });
    }
}