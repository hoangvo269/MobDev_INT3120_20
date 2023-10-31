package com.mobdev.homework.week5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    Button b2;

    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Time Picker
        b2 = findViewById(R.id.btnTime);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePickerFrag =
                        new TimePickerFragment();

                timePickerFrag.show(
                        getSupportFragmentManager(), "Pick Time Now:"
                );

            }
        });


        Button b3 = findViewById(R.id.btnDate);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment =
                        new DatePickerFragment();

                dialogFragment.show(
                        getSupportFragmentManager(),
                        "Pick A Date"
                );
            }
        });

        viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        viewPagerAdapter.addFrag(new BlankFragment1());
        viewPagerAdapter.addFrag(new BlankFragment2());
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager2.setAdapter(viewPagerAdapter);

        TabLayout tabLayout;

        tabLayout = findViewById(R.id.tablayout);

        new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("" + position + 1);
            }
        }
        ).attach();
    }
}