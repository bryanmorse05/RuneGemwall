package com.example.bryan.runegemwall.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.adapters.SkillsRecyclerAdapter;
import com.example.bryan.runegemwall.models.SkillsModel;

import java.util.ArrayList;
import java.util.List;

public class Skills_Fragment extends Fragment {

    public Skills_Fragment() {
        // Required empty public constructor
    }

    private List<SkillsModel> skillsModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SkillsRecyclerAdapter mAdapter;

    Integer strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod;
    Boolean acrobaticsChecked, animalHandlingChecked, arcanaChecked, athleticsChecked, deceptionChecked,
            historyChecked, insightChecked, intimidationChecked, investigationChecked, medicineChecked,
            natureChecked, perceptionChecked, performanceChecked, persuasionChecked, religionChecked,
            sleightOfHandChecked, stealthChecked, survivalChecked;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills_, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
        strengthMod = sharedPreferences.getInt("StrengthMod", 0);
        dexterityMod = sharedPreferences.getInt("DexterityMod", 0);
        constitutionMod = sharedPreferences.getInt("ConstitutionMod", 0);
        intelligenceMod = sharedPreferences.getInt("IntelligenceMod", 0);
        wisdomMod = sharedPreferences.getInt("WisdomMod", 0);
        charismaMod = sharedPreferences.getInt("CharismaMod", 0);

        acrobaticsChecked = sharedPreferences.getBoolean("Acrobatics", false);
        animalHandlingChecked = sharedPreferences.getBoolean("Animal Handling", false);
        arcanaChecked = sharedPreferences.getBoolean("Arcana", false);
        athleticsChecked = sharedPreferences.getBoolean("Athletics", false);
        deceptionChecked = sharedPreferences.getBoolean("Deception", false);
        historyChecked = sharedPreferences.getBoolean("History", false);
        insightChecked = sharedPreferences.getBoolean("Insight", false);
        intimidationChecked = sharedPreferences.getBoolean("Intimidation", false);
        investigationChecked = sharedPreferences.getBoolean("Investigation", false);
        medicineChecked = sharedPreferences.getBoolean("Medicine", false);
        natureChecked = sharedPreferences.getBoolean("Nature", false);
        perceptionChecked = sharedPreferences.getBoolean("Perception", false);
        performanceChecked = sharedPreferences.getBoolean("Performance", false);
        persuasionChecked = sharedPreferences.getBoolean("Persuasion", false);
        religionChecked = sharedPreferences.getBoolean("Religion", false);
        sleightOfHandChecked = sharedPreferences.getBoolean("Sleight Of Hand", false);
        stealthChecked = sharedPreferences.getBoolean("Stealth", false);
        survivalChecked = sharedPreferences.getBoolean("Survival", false);


        recyclerView = view.findViewById(R.id.skillsRecyclerView);

        mAdapter = new SkillsRecyclerAdapter(skillsModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        PopulateSkillData();

        // Inflate the layout for this fragment

        return view;
    }

    private void PopulateSkillData() {
        SkillsModel skill = new SkillsModel("Acrobatics", "Dex", dexterityMod, acrobaticsChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Animal Handling", "Wis", wisdomMod, animalHandlingChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Arcana", "Int", intelligenceMod, arcanaChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Athletics", "Str", strengthMod, athleticsChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Deception", "Cha", charismaMod, deceptionChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("History", "Int", intelligenceMod, historyChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Insight", "Wis", wisdomMod, insightChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Intimidation", "Cha", charismaMod, intimidationChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Investigation", "Int", intelligenceMod, investigationChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Medicine", "Wis", wisdomMod, medicineChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Nature", "Int", intelligenceMod, natureChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Perception", "Wis", wisdomMod, perceptionChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Performance", "Cha", charismaMod, performanceChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Persuasion", "Cha", charismaMod, persuasionChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Religion", "Int", intelligenceMod, religionChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Sleight of Hand", "Dex", dexterityMod, sleightOfHandChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Stealth", "Dex", dexterityMod, stealthChecked);
        skillsModelList.add(skill);

        skill = new SkillsModel("Survival", "Wis", wisdomMod, survivalChecked);
        skillsModelList.add(skill);

        mAdapter.notifyDataSetChanged();
    }
}
