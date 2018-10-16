package com.example.bryan.runegemwall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;

public class MonkClass_Activity extends AppCompatActivity {

    TextView monkDescriptionText;
    String allThisMonk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monk_class_);

        monkDescriptionText = findViewById(R.id.monkDescriptionText);

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Monk Class");

        allThisMonk = "Hit Points\n"+
        "Hit Dice: 1D8 per monk level\n"+
        "Hit Points at 1st Level: 8 + your Constitution modifier\n"+
        "Hit Points at Higher Levels: 1D8 (or 5) + your Constitution modifier per monk level after 1st\n\n"+
        "Proficiencies\n"+
        "Armor: None\n"+
        "Weapons: Simple weapons, shortswords\n"+
        "Tools: Choose one type of artisan's tools or one musical instrument\n"+
        "Saving Throws: Strength, Dexterity\n"+
        "Skills: Choose two from Acrobatics, Athletics, History, Insight, Religion, and Stealth\n\n"+
        "Equipment\n"+
        "You start with the following equipment, in addition to the equipment granted by your background:\n"+
        "(a) a shortsword or (b) any simple weapon\n"+
        "(a) a dungeoneer's pack or (b) an explorer's pack\n"+
        "10 darts";

        monkDescriptionText.setText(allThisMonk);


    }
}
