package com.example.bryan.runegemwall.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bryan.runegemwall.R;

public class HomePage_Activity extends AppCompatActivity {

    Button statsButton, loreButton, storeButton, googleSheetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        statsButton = findViewById(R.id.statsButton);
        loreButton = findViewById(R.id.loreButton);
        storeButton = findViewById(R.id.storeButton);
        googleSheetButton = findViewById(R.id.googleSheetButton);

        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CharacterStats_Activity.class);
                startActivity(intent);
            }
        });

        loreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lore_Activity.class);
                startActivity(intent);
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dndbeyond.com/equipment"));
                startActivity(browserIntent);
            }
        });

        googleSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/18gpplrkmJR6B_MSf68brrKnQJGgjkjvZdGI7jymdVeo/edit#gid=903375314"));
                startActivity(browserIntent);
            }
        });


    }

}
