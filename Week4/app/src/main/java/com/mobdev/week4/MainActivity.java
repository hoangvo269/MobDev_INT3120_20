package com.mobdev.week4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.constraint_layout2);
//    }

    CheckBox box1, box2;
    Button btn;

    RadioGroup radioGroup;

    Spinner spinner;

    TimePicker timePicker;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        // Checkbox
//        box1 = findViewById(R.id.checkbox1);
//        box2 = findViewById(R.id.checkbox2);


        //  Radio Group - Radio Buttons
//        radioGroup = findViewById(R.id.radioGroup);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
//                RadioButton radioButton = findViewById(checked);
//                Toast.makeText(MainActivity.this,
//                        "Selected: "+radioButton.getText(),
//                        Toast.LENGTH_LONG).show();
//
//
//
//            }
//        });


        // Spinner
//        spinner = findViewById(R.id.spinner);
//
//        String[] courses = {"C++", "Java", "Kotlin", "Data Structures"};
//
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
//
//        ad.setDropDownViewResource(
//                android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(ad);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this,
//                        "You Select: "+courses[i],
//                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item1) {
            goTo1();

        } else if(id == R.id.item2) {
            goTo2();
        }

        return super.onOptionsItemSelected(item);
    }

    public void goTo1() {
        Intent intent = new Intent(this, MainActivity1.class);
        startActivity(intent);
    }

    public void goTo2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}