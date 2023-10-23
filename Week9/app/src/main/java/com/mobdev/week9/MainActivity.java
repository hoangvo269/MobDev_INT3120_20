package com.mobdev.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button button, button2;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences("SILENT_MODE", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("silentMode", true);
        editor.apply();

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(read());
            }
        });

        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "hello.txt";
                String content = editText.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    fos.write(content.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), "File written to internal storage", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error writing to internal storage", Toast.LENGTH_SHORT).show();
                }

//                try {
//                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
//                    fos.write(string.getBytes());
//                    fos.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }
        });
    }

    public String read() {
        try {
            InputStream inputStream = getApplicationContext().getResources().openRawResource(R.raw.hello);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            inputStream.close();

            String fileContent = sb.toString();
            return fileContent;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Can't read file";
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }
}