package com.example.bryan.runegemwall.activities;

//import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bryan.runegemwall.fragments.CoreStats_Fragment;
import com.example.bryan.runegemwall.fragments.Equipment_Fragment;
import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.fragments.FeaturesTraits_Fragment;
import com.example.bryan.runegemwall.fragments.SavingThrows_Fragment;
import com.example.bryan.runegemwall.fragments.Skills_Fragment;

public class CharacterStats_Activity extends AppCompatActivity {

    ConstraintLayout statsLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats_);

        statsLayout = findViewById(R.id.statsLayout);
        tabLayout = findViewById(R.id.statsTabLayout);

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

}
