package com.example.bryan.runegemwall.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bryan.runegemwall.R;

public class HomePage_Activity extends AppCompatActivity {

    Button statsButton, loreButton, storeButton, glossaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        statsButton = findViewById(R.id.statsButton);
        loreButton = findViewById(R.id.loreButton);
        storeButton = findViewById(R.id.storeButton);
        glossaryButton = findViewById(R.id.glossaryButton);

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
                //Do something
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do something
            }
        });

        glossaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do something
            }
        });


    }

}
