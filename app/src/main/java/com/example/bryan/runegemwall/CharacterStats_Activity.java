package com.example.bryan.runegemwall;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class CharacterStats_Activity extends AppCompatActivity {

    FrameLayout statsFrameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats_);

        statsFrameLayout = findViewById(R.id.statsFrameLayout);
        tabLayout = findViewById(R.id.tab_layout);

        //Code that will display the character core stats first (the first tab)
        Fragment startingFragment = new CoreStats_Fragment();
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction sft = sfm.beginTransaction();
        sft.replace(R.id.statsFrameLayout, startingFragment);
        sft.commit();

        //perform setOnTabSelectedlistener even on TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //get the current tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new CharacterStatsFragment();
                        break;
                    case 1:
                        fragment = new SavingThrowsFragment();
                        break;
                    case 2:
                        fragment = new ProficiencyFragment();
                        break;
                    case 3:
                        fragment = new EquipmentFragment();
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.statsFrameLayout, fragment);
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
