package com.mobdev.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        Button button1 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSth();
            }
        });

    }

    public void go() {
        Intent intent = new Intent(this, GreetingActivity.class);
        startActivity(intent);

    }

    public void sendMessage() {
        String fullName = editText1.getText().toString();
        String message = editText2.getText().toString();

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message", message);

        startActivity(intent);

    }

    public void doSth() {
        Uri webpage = Uri.parse("https://www.google.com");

//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "dog");
        startActivity(intent);
    }

}