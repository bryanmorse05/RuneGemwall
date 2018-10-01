package com.example.bryan.runegemwall.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.models.SkillsModel;

import java.util.List;

public class SkillsRecyclerAdapter extends RecyclerView.Adapter<SkillsRecyclerAdapter.MyViewHolder> {

    private List<SkillsModel> skillsModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView skillName, skillType, skillValue;
        public CheckBox skillChecked;
        public SharedPreferences sharedPreferences;
        public SharedPreferences.Editor editor;
        Integer proficiencyValue;

        public MyViewHolder(View view) {
            super(view);

            skillName = view.findViewById(R.id.skillName);
            skillType = view.findViewById(R.id.skillType);
            skillValue = view.findViewById(R.id.skillValue);
            skillChecked = view.findViewById(R.id.skillCheckBox);

            sharedPreferences = view.getContext().getSharedPreferences("RuneGemwallSaveData", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            proficiencyValue = sharedPreferences.getInt("CharacterProficiency", 0);
        }
    }

    public SkillsRecyclerAdapter(List<SkillsModel> skillsModelList) {
        this.skillsModelList = skillsModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skill_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        final SkillsModel skillsModel = skillsModelList.get(position);
        holder.skillName.setText(skillsModel.getSkillName());
        holder.skillType.setText("(" + skillsModel.getSkillType() + ")");
        holder.skillChecked.setChecked(skillsModel.getSkillChecked());

        //Check to see if checkbox is already enabled on first view
        if (holder.skillChecked.isChecked()) {
            holder.skillValue.setText(String.valueOf(skillsModel.getSkillValue() + holder.proficiencyValue));
        }
        else {
            holder.skillValue.setText(String.valueOf(skillsModel.getSkillValue()));
        }

        holder.skillChecked.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (holder.skillChecked.isChecked()) {
                    holder.skillValue.setText(String.valueOf(skillsModel.getSkillValue() + holder.proficiencyValue));
                    holder.editor.putBoolean(skillsModel.getSkillName(), true);
                }
                else {
                    holder.skillValue.setText(String.valueOf(skillsModel.getSkillValue()));
                    holder.editor.putBoolean(skillsModel.getSkillName(), false);
                }
                holder.editor.apply();
            }
        });

    }

    @Override
    public int getItemCount() {

        return skillsModelList.size();
    }

}
