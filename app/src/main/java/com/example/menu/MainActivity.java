package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView mainImg;
    Switch mainSwitch;
    RadioButton radio_oreo, radio_pie, radio_q;
    TextView Text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImg = findViewById(R.id.mainImg);
        mainSwitch = findViewById(R.id.mainSwitch);
        radio_oreo = findViewById(R.id.radio_oreo);
        radio_pie = findViewById(R.id.radio_pie);
        radio_q = findViewById(R.id.radio_q);
        Text = findViewById(R.id.txt3);
        button = findViewById(R.id.resetBtn);

        mainSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mainSwitch.isChecked()) {
                    Text.setVisibility(View.VISIBLE);
                    radio_oreo.setVisibility(View.VISIBLE);
                    radio_pie.setVisibility(View.VISIBLE);
                    radio_q.setVisibility(View.VISIBLE);
                    mainImg.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                } else {
                    Text.setVisibility(View.GONE);
                    radio_oreo.setVisibility(View.GONE);
                    radio_pie.setVisibility(View.GONE);
                    radio_q.setVisibility(View.GONE);
                    mainImg.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                }
            }
        });

        radio_oreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImg.setImageResource(R.drawable.android_oreo);
            }
        });

        radio_pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImg.setImageResource(R.drawable.android_pie);
            }
        });

        radio_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImg.setImageResource(R.drawable.android_q);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImg.setImageResource(R.drawable.android_oreo);
                radio_oreo.setChecked(true);
                mainSwitch.setChecked(false);
            }
        });
    }
}