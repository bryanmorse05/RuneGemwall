package com.example.bryan.runegemwall.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        //Implementing to test save functionality, will remove later
        /*
        SharedPreferences sharedPreferences = getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //access the file
        editor.putInt("StrengthValue", 14);
        editor.putInt("DexterityValue", 17);
        editor.putInt("ConstitutionValue", 14);
        editor.putInt("IntelligenceValue", 14);
        editor.putInt("WisdomValue", 17);
        editor.putInt("CharismaValue", 16);
        editor.putInt("CharacterHP", 10);
        editor.putInt("CharacterAC", 16);
        editor.putInt("CharacterSpeed", 40);
        editor.putInt("CharacterLevel", 1);
        editor.putInt("CharacterExperience", 0);
        editor.apply();

*/
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
