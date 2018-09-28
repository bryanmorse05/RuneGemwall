package com.example.bryan.runegemwall.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.models.SkillsModel;

import java.util.List;

public class SkillsRecyclerAdapter extends RecyclerView.Adapter<SkillsRecyclerAdapter.MyViewHolder> {

    private List<SkillsModel> skillsModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView skillName, skillType, skillValue;

        public MyViewHolder(View view) {
            super(view);
            skillName = view.findViewById(R.id.skillName);
            skillType = view.findViewById(R.id.skillType);
            skillValue = view.findViewById(R.id.skillValue);
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        SkillsModel skillsModel = skillsModelList.get(position);
        holder.skillName.setText(skillsModel.getSkillName());
        holder.skillType.setText("(" + skillsModel.getSkillType() + ")");
        holder.skillValue.setText(String.valueOf(skillsModel.getSkillValue()));

    }

    @Override
    public int getItemCount() {

        return skillsModelList.size();
    }

}
