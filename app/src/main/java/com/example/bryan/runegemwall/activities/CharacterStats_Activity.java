package com.example.bryan.runegemwall.activities;

//import android.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bryan.runegemwall.fragments.CoreStats_Fragment;
import com.example.bryan.runegemwall.fragments.Equipment_Fragment;
import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.fragments.FeaturesTraits_Fragment;
import com.example.bryan.runegemwall.fragments.SavingThrows_Fragment;
import com.example.bryan.runegemwall.fragments.Skills_Fragment;

public class CharacterStats_Activity extends AppCompatActivity {

    ConstraintLayout statsConstraintLayout;     //THE BIG ONE  The entire activity layout
    ConstraintLayout statsLayout;               //The layout view to be replaced
    TabLayout tabLayout;
    EditText currentHitPointsET, currentArmorClassET, currentCharacterSpeedET, currentCharacterLevelET, currentCharacterExperienceET;
    TextView hitPointsText;                     //Only needed to set the focus on it instead of the EditText fields
    Integer hitPointsValue, armorClassValue, characterSpeedValue, characterLevelValue, characterExperienceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats_);

        statsConstraintLayout = findViewById(R.id.statsConstraintLayout);
        statsLayout = findViewById(R.id.statsLayout);
        tabLayout = findViewById(R.id.statsTabLayout);
        currentHitPointsET = findViewById(R.id.currentHitPoints);
        currentArmorClassET = findViewById(R.id.currentArmorClass);
        currentCharacterSpeedET = findViewById(R.id.currentCharacterSpeed);
        currentCharacterLevelET = findViewById(R.id.currentCharacterLevel);
        currentCharacterExperienceET = findViewById(R.id.currentCharacterExperience);
        hitPointsText = findViewById(R.id.hitPointsText);

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Stats");

        //The text field is focused by default so the HP EditText is not
        hitPointsText.setFocusableInTouchMode(true);
        hitPointsText.requestFocus();

        //Load the values for HP, AC, SPD, and LVL
        SharedPreferences sharedPreferences = getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); //write to the file
        hitPointsValue = sharedPreferences.getInt("CharacterHP", 0);
        armorClassValue = sharedPreferences.getInt("CharacterAC", 0);
        characterSpeedValue = sharedPreferences.getInt("CharacterSpeed", 0);
        characterLevelValue = sharedPreferences.getInt("CharacterLevel", 0);
        characterExperienceValue = sharedPreferences.getInt("CharacterExperience", 0);

        //Populate the corresponding EditText fields
        currentHitPointsET.setText(String.valueOf(hitPointsValue));
        currentArmorClassET.setText(String.valueOf(armorClassValue));
        currentCharacterSpeedET.setText(String.valueOf(characterSpeedValue));
        currentCharacterLevelET.setText(String.valueOf(characterLevelValue));
        currentCharacterExperienceET.setText(String.valueOf(characterExperienceValue));



        //When the fields are touched is when the cursor appears.  It appears always on by default
        currentHitPointsET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentHitPointsET.setCursorVisible(true);
            }
        });

        currentArmorClassET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentArmorClassET.setCursorVisible(true);
            }
        });

        currentCharacterSpeedET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentCharacterSpeedET.setCursorVisible(true);
            }
        });

        currentCharacterLevelET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentCharacterLevelET.setCursorVisible(true);
            }
        });

        currentCharacterExperienceET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentCharacterExperienceET.setCursorVisible(true);
            }
        });

        //Call this whenever the user touches outside of the keyboard and the EditText fields,
        //hiding the keyboard and making the cursors invisible again
        statsConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentHitPointsET.setCursorVisible(false);
                currentArmorClassET.setCursorVisible(false);
                currentCharacterSpeedET.setCursorVisible(false);
                currentCharacterLevelET.setCursorVisible(false);
                currentCharacterExperienceET.setCursorVisible(false);

                //I only need this so the focus is on something else other than the editText fields
                hitPointsText.setFocusableInTouchMode(true);
                hitPointsText.requestFocus();

                //Hides the keyboard from view
                hideKeyboardFrom(getApplicationContext(), view);

            }
        });

        //Code that will display the character core stats first (the first tab)
        Fragment startingFragment = new CoreStats_Fragment();
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction sft = sfm.beginTransaction();
        sft.replace(R.id.statsLayout, startingFragment);
        sft.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //get the current tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new CoreStats_Fragment();
                        break;
                    case 1:
                        fragment = new Skills_Fragment();
                        break;
                    case 2:
                        fragment = new SavingThrows_Fragment();
                        break;
                    case 3:
                        fragment = new Equipment_Fragment();
                        break;
                    case 4:
                        fragment = new FeaturesTraits_Fragment();
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.statsLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }

    //Cool little function I found online that works with fragments.  Can touch anywhere.
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
