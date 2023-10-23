package com.mobdev.week8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver br;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        br = new MyBroadcastReceiver();
        registerReceiver(br, intentFilter);

//        button = findViewById(R.id.button);
//
//        doSth();
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent("com.mobdev.week8.ACTION_MY_EVENT");
//                intent.putExtra("message", "Hello, this is a broadcast event!");
//
//                sendBroadcast(intent);
//                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
//
//            }
//        });
    }

    @Override
    protected void onStop() {

        super.onStop();
        if (br != null) {
            unregisterReceiver(br);
            Log.d("Broadcast", "Unregister");

        }

    }

    public void doSth() {
        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.mobdev.week8.ACTION_MY_EVENT");
        registerReceiver(myBroadcastReceiver, intentFilter);
    }
}