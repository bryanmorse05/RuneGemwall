package com.example.bryan.runegemwall.fragments;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills_, container, false);

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
        SkillsModel skill = new SkillsModel("Acrobatics", "Dex", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Animal Handling", "Wis", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Arcana", "Int", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Athletics", "Str", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Deception", "Cha", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("History", "Int", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Insight", "Wis", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Intimidation", "Cha", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Investigation", "Int", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Medicine", "Wis", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Nature", "Int", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Perception", "Wis", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Performance", "Cha", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Persuasion", "Cha", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Religion", "Int", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Sleight of Hand", "Dex", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Stealth", "Dex", 0);
        skillsModelList.add(skill);

        skill = new SkillsModel("Survival", "Wis", 0);
        skillsModelList.add(skill);

        mAdapter.notifyDataSetChanged();
    }
}
