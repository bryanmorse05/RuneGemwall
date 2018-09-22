package com.example.bryan.runegemwall.activities;

//import android.app.Fragment;
import android.app.Activity;
import android.content.Context;
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
import android.widget.FrameLayout;
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
    EditText currentHitPoints, currentArmorClass, currentCharacterSpeed;
    TextView hitPointsText;                     //Only need to set the focus on it instead of the EditText fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats_);

        statsConstraintLayout = findViewById(R.id.statsConstraintLayout);
        statsLayout = findViewById(R.id.statsLayout);
        tabLayout = findViewById(R.id.statsTabLayout);
        currentHitPoints = findViewById(R.id.currentHitPoints);
        currentArmorClass = findViewById(R.id.currentArmorClass);
        currentCharacterSpeed = findViewById(R.id.currentCharacterSpeed);
        hitPointsText = findViewById(R.id.hitPointsText);

        //Back button enabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Stats");

        //The text field is focused by default so the HP EditText is not
        hitPointsText.setFocusableInTouchMode(true);
        hitPointsText.requestFocus();

        //When the fields are touched is when the cursor appears.  It appears always on by default
        currentHitPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentHitPoints.setCursorVisible(true);
            }
        });

        currentArmorClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentArmorClass.setCursorVisible(true);
            }
        });

        currentCharacterSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentCharacterSpeed.setCursorVisible(true);
            }
        });

        //Call this whenever the user touches outside of the keyboard and the EditText fields,
        //hiding the keyboard and making the cursors invisible again
        statsConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentHitPoints.setCursorVisible(false);
                currentArmorClass.setCursorVisible(false);
                currentCharacterSpeed.setCursorVisible(false);

                //I only need this so the focus is on something else other than the editText fields
                hitPointsText.setFocusableInTouchMode(true);
                hitPointsText.requestFocus();

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
