package com.example.bryan.runegemwall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;

public class Lore_Activity extends AppCompatActivity {

    TextView personalityText, idealsText, bondsText, flawsText;
    String personalityDescription, idealsDescription, bondsDescription, flawsDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lore);

        personalityText = findViewById(R.id.lorePersonalityTraitsDescription);
        idealsText = findViewById(R.id.loreIdealsDescription);
        bondsText = findViewById(R.id.loreBondsDescription);
        flawsText = findViewById(R.id.loreFlawsDescription);

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Character Lore");

        personalityDescription = "Bubbly, dancer, Lea";
        idealsDescription = "Everyone have a good time exploring";
        bondsDescription = "Monastery of the Sore First and Rosy Palma";
        flawsDescription = "Cannot tolerate the presence of milk.  Does not take into account negative consequences";

        personalityText.setText(personalityDescription);
        idealsText.setText(idealsDescription);
        bondsText.setText(bondsDescription);
        flawsText.setText(flawsDescription);
    }
}
