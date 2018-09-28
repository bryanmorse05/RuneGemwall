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
import java.util.zip.Inflater;

public class Skills_Fragment extends Fragment {

    public Skills_Fragment() {
        // Required empty public constructor
    }

    private List<SkillsModel> skillsModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SkillsRecyclerAdapter mAdapter;

    Integer strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod;

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
        SkillsModel skill = new SkillsModel("Acrobatics", "Dex", dexterityMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Animal Handling", "Wis", wisdomMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Arcana", "Int", intelligenceMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Athletics", "Str", strengthMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Deception", "Cha", charismaMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("History", "Int", intelligenceMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Insight", "Wis", wisdomMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Intimidation", "Cha", charismaMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Investigation", "Int", intelligenceMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Medicine", "Wis", wisdomMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Nature", "Int", intelligenceMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Perception", "Wis", wisdomMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Performance", "Cha", charismaMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Persuasion", "Cha", charismaMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Religion", "Int", intelligenceMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Sleight of Hand", "Dex", dexterityMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Stealth", "Dex", dexterityMod);
        skillsModelList.add(skill);

        skill = new SkillsModel("Survival", "Wis", wisdomMod);
        skillsModelList.add(skill);

        mAdapter.notifyDataSetChanged();
    }
}
