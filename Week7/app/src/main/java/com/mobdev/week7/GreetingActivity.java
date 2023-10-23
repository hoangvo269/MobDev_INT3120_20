package com.mobdev.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");
        String message = intent.getStringExtra("message");

        textView1.setText(fullName);
        textView2.setText(message);

    }
}