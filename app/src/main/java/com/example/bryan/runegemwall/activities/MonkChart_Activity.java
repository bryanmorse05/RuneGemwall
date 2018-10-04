package com.example.bryan.runegemwall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bryan.runegemwall.R;

public class MonkChart_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monk_chart_);

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("The Monk Chart");


    }
}
