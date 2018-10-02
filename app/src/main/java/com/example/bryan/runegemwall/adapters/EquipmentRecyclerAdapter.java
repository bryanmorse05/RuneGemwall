package com.example.bryan.runegemwall.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.models.EquipmentModel;

import java.util.ArrayList;

public class EquipmentRecyclerAdapter extends RecyclerView.Adapter<EquipmentRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<EquipmentModel> equipmentModelArrayList;

    public EquipmentRecyclerAdapter(ArrayList<EquipmentModel> equipmentModelArrayList) {
        super();
        this.equipmentModelArrayList = equipmentModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.equipment_list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final EquipmentModel equipmentModel = equipmentModelArrayList.get(position);

        TextView nameDisplay = holder.nameDisplay;
        nameDisplay.setText(equipmentModel.getName());

        TextView ownerDisplay = holder.descriptionDisplay;
        ownerDisplay.setText(equipmentModel.getDescription());

        TextView playersDisplay = holder.statsDisplay;
        playersDisplay.setText(equipmentModel.getStats());

        TextView timeDisplay = holder.costDisplay;
        timeDisplay.setText(equipmentModel.getCost());

    }

    @Override
    public int getItemCount() {
        return equipmentModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameDisplay;
        public TextView descriptionDisplay;
        public TextView statsDisplay;
        public TextView costDisplay;

        public ViewHolder(View itemView) {

            super(itemView);

            nameDisplay = itemView.findViewById(R.id.equipmentName);
            descriptionDisplay = itemView.findViewById(R.id.equipmentDescription);
            statsDisplay = itemView.findViewById(R.id.equipmentStats);
            costDisplay = itemView.findViewById(R.id.equipmentCost);

            context = itemView.getContext();
        }
    }
}
