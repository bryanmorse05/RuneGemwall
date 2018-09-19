package com.example.bryan.runegemwall;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
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

        statsFrameLayout = findViewById(R.id.statsLayout);
        tabLayout = findViewById(R.id.statsTabLayout);

        //Code that will display the character core stats first (the first tab)
        Fragment startingFragment = new CoreStats_Fragment();
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction sft = sfm.beginTransaction();
        sft.replace(R.id.statsLayout, startingFragment);
        sft.commit();

        //perform setOnTabSelectedlistener even on TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //get the current tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new CoreStats_Fragment();
                        break;
                    case 1:
                        fragment = new Abilities_Fragment();
                        break;
                    case 2:
                        fragment = new SkillsTalents_Fragment();
                        break;
                    case 3:
                        fragment = new Equipment_Fragment();
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
