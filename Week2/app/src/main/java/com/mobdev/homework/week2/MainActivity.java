package com.mobdev.homework.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.mobdev.homework.R;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private TextView sum;
    private TextView currentText;
    private Button donateBtn;
    private int money = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week2);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(1500);
        numberPicker.setValue(999);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                currentText = findViewById(R.id.currentText);
                currentText.setText("" + numberPicker.getValue());
            }
        });

        donateBtn = findViewById(R.id.donateBtn);
        sum = findViewById(R.id.sumAmount);

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tmp = numberPicker.getValue();
                money += tmp;
                sum.setText("Total so far $" + money);
            }
        });
    }
}