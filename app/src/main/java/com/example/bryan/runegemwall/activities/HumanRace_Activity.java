package com.example.bryan.runegemwall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;

public class HumanRace_Activity extends AppCompatActivity {

    TextView raceDescriptionText;
    String allThisTextStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_race_);

        raceDescriptionText = findViewById(R.id.raceDescriptionText);

        raceDescriptionText.setMovementMethod(new ScrollingMovementMethod());

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Human Race");

        allThisTextStuff = "Ability Score Increase:\nYour ability scores each increase by 1.\n\n"+
        "Age:\nHumans reach adulthood in their late teens and live less than a century.\n\n"+
        "Alignment:\nHumans tend toward no particular alignment.  The best and the worst are found among them.\n\n"+
        "Size:\nHumans vary widely in height and build, from barely 5 feet to well over 6 feet tall.  " +
                "Regardless of your position in that range, your size is Medium.\n\n"+
        "Speed:\nYour base walking speed is 30 feet.\n\n"+
        "Languages:\nYou can speak, read, and write Common and one extra language of your choice.  " +
                "Humans typically larn the languages of other peoples they deal with, including obscure dialects.  " +
                "THey are fond of sprinkling their speech with words borrowed from other tongues: Orc curses, " +
                "Elvish musical expressions, Dwarvish military phrases, and so on.\n\n"+
        "Variant Human Traits:\nIf your campaign uses the optional feat rules from chapter 5, your " +
                "Dungeon Master might allow these variant traits, all of which replace the human's ability score traits:\n\n"+
        "Ability Score Increase: Two different ability scores of your choice increase by 1.\n"+
        "Skills: You gain proficiency in one skill of your choice.\n"+
        "Feat: You gain one feat of your choice";


        raceDescriptionText.setText(allThisTextStuff);

    }
}
